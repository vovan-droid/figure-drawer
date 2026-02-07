package org.vova.drawing.core;

import java.util.Arrays;

/**
 * <p>
 * This class intentionally stays close to the output and provides a small set of reusable building blocks
 * used by higher-level drawers (e.g., house/figure services):
 * </p>
 **/
public class PatternDrawerService extends CustomizableDrawer<PatternDrawerService> {

    private PatternDrawerService() {
    }

    public static PatternDrawerService newInstance() {
        return new PatternDrawerService();
    }

    public PatternDrawerService printDottedLinesEx(int linesNumber, Point... points) {
        LineBuffer buffer = new LineBuffer();
        for (int i = 0; i < linesNumber; i++) {
            for (Point point : points) {
                buffer.setChar(point.nextPosition());
            }
            buffer.print();
        }
        return this;
    }

    public PatternDrawerService printDottedLines(int linesNumber, Dot... dots) {
        for (int i = 0; i < linesNumber; i++) {
            int[] indents = Arrays.stream(dots).mapToInt(Dot::getNextIndent).toArray();
            printDottedLine(indents);
        }
        return this;
    }

    public PatternDrawerService printDottedLine(int... amountOfSpacesBeforeAsterix) {
        for (int ofSpacesBeforeAsterix : amountOfSpacesBeforeAsterix) {
            printSpaces(ofSpacesBeforeAsterix);
            console.print(drawingChar);
        }
        console.println();
        return this;
    }

    public PatternDrawerService printSpaces(int amountOfSpacesBeforeChar1) {
        for (int i = 0; i < amountOfSpacesBeforeChar1; i++) {
            console.print(drawingSpace);
        }
        return this;
    }

    public PatternDrawerService printSolidLine(int amountOfAsterixes) {
        for (int i = 0; i < amountOfAsterixes; i++) {
            console.print(drawingChar);
        }
        console.println();
        return this;
    }

    /**
     * Fabric method of a class Dot
     *
     * @param amountOfSpacesInitial
     * @param amountOfSpacesStep
     * @return
     */
    public static Dot dot(int amountOfSpacesInitial, int amountOfSpacesStep) {
        return new Dot(amountOfSpacesInitial, amountOfSpacesStep);
    }

    public static Point point(int initialPosition, int step) {
        return new Point(initialPosition, step);
    }

    /**
     * Mutable helper that represents a horizontally "moving dot" in a multi-line pattern.
     * <p>
     * A {@code Dot} tracks how many leading spaces should be printed before a drawing character
     * on each successive row. Every call to {@link #getNextIndent()} advances the dot horizontally
     * by a fixed step, allowing higher-level code to create slanted or diagonal dotted lines.
     * </p>
     */
    public static class Dot {
        /**
         * Fixed horizontal step applied on every row in comparison to the previous one.
         * <p>
         * Positive values move the dot to the right, negative values move it to the left.
         * </p>
         */
        private final int amountOfSpacesStep;
        private int amountOfSpaces;

        private Dot(int amountOfSpacesInitial, int amountOfSpacesStep) {
            this.amountOfSpacesStep = amountOfSpacesStep;
            this.amountOfSpaces = amountOfSpacesInitial - amountOfSpacesStep;
        }

        public int getNextIndent() {
            return amountOfSpaces += amountOfSpacesStep;
        }
    }

    public static class Point {
        /**
         * Fixed horizontal step applied on every call to {@link #nextPosition()}.
         * <p>
         * Positive values move the point to the right, negative values move it to the left.
         * </p>
         */
        private final int step;
        /**
         * Current horizontal position of the point.
         */
        private int current;

        private Point(int initialPosition, int step) {
            this.step = step;
            this.current = initialPosition - step;
        }

        public int nextPosition() {
            return current += step;
        }
    }

    /**
     * Line-oriented buffer that allows building a full output line before printing it.
     * <p>
     * {@code LineBuffer} abstracts away manual space handling by internally managing
     * a {@link StringBuilder}. Characters can be placed at arbitrary horizontal positions
     * using {@link #setChar(int)}, and missing spaces are automatically filled.
     * </p>
     * <p>
     * This makes it possible to construct complex lines with multiple moving points
     * (e.g. crossed diagonals) without caring about ordering or manual padding.
     * </p>
     * <p>
     * The buffer is cleared after every {@link #print()} call and is intended to be
     * reused for consecutive lines.
     * </p>
     */
    private class LineBuffer {
        /**
         * Internal mutable buffer used to construct a single output line.
         */
        private final StringBuilder sb = new StringBuilder();

        public void setChar(int position) {
            if (position < 0) {
                throw new IllegalArgumentException("Position cannot be negative");
            }
            while (sb.length() <= position) {
                sb.append(drawingSpace);
            }
            sb.setCharAt(position, drawingChar.charAt(0));
        }

        public void print() {
            console.println((sb.toString()));
            sb.setLength(0);
        }
    }
}
