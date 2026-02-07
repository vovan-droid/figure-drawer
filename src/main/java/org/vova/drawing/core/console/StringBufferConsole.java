package org.vova.drawing.core.console;

public class StringBufferConsole implements Console {

    private final StringBuilder sb = new StringBuilder();

    @Override
    public void print(String string) {
        sb.append(string);
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
