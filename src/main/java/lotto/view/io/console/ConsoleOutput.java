package lotto.view.io.console;

import lotto.view.io.Output;

public class ConsoleOutput implements Output {

    @Override
    public void printLine(final String text) {
        System.out.println(text);
    }
}
