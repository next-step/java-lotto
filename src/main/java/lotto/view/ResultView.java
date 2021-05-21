package lotto.view;

import java.io.PrintStream;

public class ResultView {
    PrintStream view = new PrintStream(System.out);
    public void enter() {
        view.println("");
    }

    public void println(String message) {
        view.println(message);
    }

    public void println(Object obj) {
        view.println(obj);
    }

    public void print(String message) {
        view.print(message);
    }
}
