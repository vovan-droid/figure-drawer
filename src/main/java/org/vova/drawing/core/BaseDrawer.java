package org.vova.drawing.core;

public abstract class BaseDrawer<T> extends CustomizableDrawer<T> {

    protected PatternDrawerService createPatternDrawer() {
        return PatternDrawerService.newInstance()
                .withConsole(console)
                .withDrawingSpace(drawingSpace)
                .withDrawingChar(drawingChar);
    }

    @SuppressWarnings("unchecked")
    public T drawNewLine() {
        console.println();
        return (T) this;
    }

    protected void ensureOdd(int size) {
        if (size % 2 == 0) {
            throw new IllegalArgumentException("Size must be odd");
        }
    }

    protected void ensureEven(int size) {
        if (size % 2 != 0) {
            throw new IllegalArgumentException("Size must be even");
        }
    }

    protected void checkMinSize(int size, int minSize) {
        if (size < minSize) {
            throw new IllegalArgumentException("Size must be at least " + minSize);
        }
    }
}
