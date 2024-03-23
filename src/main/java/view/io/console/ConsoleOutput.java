package view.io.console;

import view.io.Output;

public class ConsoleOutput implements Output {

    @Override
    public void printLine(final String text) {
        System.out.println(text);
    }
}
