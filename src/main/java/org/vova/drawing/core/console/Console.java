package org.vova.drawing.core.console;

public interface Console {

    String LINE_BREAK = System.lineSeparator();

    void print(String string);

    default void println(String string) {
        print(string + LINE_BREAK);
    }

    default void println() {
        println("");
    }
}
