package org.vova.drawing.domain;

import org.vova.drawing.core.PatternDrawerService;
import org.vova.drawing.core.BaseDrawer;

public class FigureDrawerService extends BaseDrawer<FigureDrawerService> {

    private FigureDrawerService() {
    }

    public static FigureDrawerService newInstance() {
        return new FigureDrawerService();
    }

    public FigureDrawerService drawCrossLvl2(int size) {
        checkMinSize(size, 3);
        ensureOdd(size);
        PatternDrawerService pattern = createPatternDrawer();
        int midHeightCross = size / 2;

        // Business logic code
        for (int i = 0; i < midHeightCross; i++) {
            pattern.printDottedLine(i, size - 2 - 2 * i);
        }
        pattern.printDottedLine(midHeightCross);
        for (int i = 0; i < midHeightCross; i++) {
            pattern.printDottedLine(midHeightCross - 1 - i, 1 + 2 * i);
        }
        return this;
    }

    public FigureDrawerService drawTriangle2Lvl2(int size) {
        checkMinSize(size, 3);
        ensureOdd(size);
        PatternDrawerService pattern = createPatternDrawer();
        int midHeight = size / 2 - 1;

        // Business logic code
        pattern.printDottedLine(midHeight + 1);
        for (int i = 0; i < midHeight; i++) {
            pattern.printDottedLine(midHeight - i, 2 * i + 1);
        }
        pattern.printSolidLine(size);
        return this;
    }

    public FigureDrawerService drawTriangle2Lvl1(int size) {
        if (size < 3) {
            throw new IllegalArgumentException("Size must be at least 3");
        }
        if (size % 2 == 0) {
            throw new IllegalArgumentException("Size must be odd");
        }
        int midHeight = size / 2 - 1;

        // Business logic code
        for (int i = 0; i <= midHeight; i++) {
            console.print(drawingSpace);
        }
        console.println(drawingChar);
        for (int i = 0; i < midHeight; i++) {
            for (int j = 0; j < midHeight - i; j++) {
                console.print(drawingSpace);
            }
            console.print(drawingChar);
            for (int k = 0; k < 2 * i + 1; k++) {
                console.print(drawingSpace);
            }
            console.println(drawingChar);
        }
        for (int i = 0; i < size; i++) {
            console.print(drawingChar);
        }
        console.println();
        return this;
    }

    public FigureDrawerService drawTriangle1Lvl2(int size) {
        checkMinSize(size, 2);
        PatternDrawerService pattern = createPatternDrawer();

        // Business logic code
        pattern.printDottedLine(0);
        for (int i = 0; i < size - 2; i++) {
            pattern.printDottedLine(0, i);
        }
        pattern.printSolidLine(size);
        return this;
    }

    public FigureDrawerService drawTriangle1Lvl1(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("Size must be at least 3");
        }

        // Business logic code
        console.println(drawingChar);
        for (int i = 0; i < size - 2; i++) {
            console.print(drawingChar);
            for (int j = 0; j < i; j++) {
                console.print(drawingSpace);
            }
            console.println(drawingChar);
        }
        for (int i = 0; i < size; i++) {
            console.print(drawingChar);
        }
        console.println();
        return this;
    }

    public FigureDrawerService drawSquareLvl2(int size) {
        checkMinSize(size, 2);

        PatternDrawerService pattern = createPatternDrawer();

        // Business logic code
        pattern.printSolidLine(size);
        for (int i = 0; i < size - 2; i++) {
            pattern.printDottedLine(0, size - 2);
        }
        pattern.printSolidLine(size);
        return this;
    }

    public FigureDrawerService drawSquareLvl1(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("Size must be at least 3");
        }

        // Business logic code
        for (int i = 0; i < size; i++) {
            console.print(drawingChar);
        }
        console.println();
        for (int i = 0; i < size - 2; i++) {
            console.print(drawingChar);
            for (int j = 0; j < size - 2; j++) {
                console.print(drawingSpace);
            }
            console.println(drawingChar);
        }
        for (int i = 0; i < size; i++) {
            console.print(drawingChar);
        }
        console.println();
        return this;
    }

    public FigureDrawerService drawHorizontalLine(int size) {
        createPatternDrawer().printSolidLine(size);
        return this;
    }

    public FigureDrawerService drawVerticalLine(int size) {
        for (int i = 0; i < size; i++) {
            console.println(drawingChar);
        }
        return this;
    }
}
