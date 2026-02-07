package org.vova.drawing.core.console;

public class StdConsole implements Console {

    @Override
    public void print(String string) {
        System.out.print(string);
    }
}
