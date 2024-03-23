package calculator.view.io.console;

import calculator.view.io.Output;

public class ConsoleOutput implements Output {

    @Override
    public void printLine(final String text) {
        System.out.println(text);
    }
}
