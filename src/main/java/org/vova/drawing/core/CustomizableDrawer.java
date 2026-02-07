package org.vova.drawing.core;

import org.vova.drawing.core.console.Console;
import org.vova.drawing.core.console.StdConsole;

public abstract class CustomizableDrawer<T> {

    protected String drawingChar = "*";
    protected String drawingSpace = " ";

    protected Console console = new StdConsole();

    @SuppressWarnings("unchecked")
    protected T withDrawingChar(String drawingChar) {
        this.drawingChar = drawingChar;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    protected T withDrawingSpace(String drawingSpace) {
        this.drawingSpace = drawingSpace;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    protected T withConsole(Console console) {
        this.console = console;
        return (T) this;
    }
}
