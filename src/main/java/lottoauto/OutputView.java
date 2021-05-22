package lottoauto;

import java.io.PrintStream;

public class OutputView {

    private static final PrintStream printStream = System.out;

    public void print(Object object) {
        printStream.print(object);
    }

    public void println(Object object) {
        printStream.println(object);
    }
}
