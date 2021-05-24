package lotto.ui.output;

import java.io.OutputStream;
import java.io.PrintStream;

public class GameOutput implements Output {
    public static final String NEW_LINE = "\n";
    private final PrintStream out;

    public GameOutput(OutputStream out) {
        this.out = (PrintStream) out;
    }

    @Override
    public void println(String text) {
        out.println(text);
    }

    @Override
    public void error(String text) {
        out.print(String.format("[부적합한 입력값] %s%s", text, NEW_LINE));
    }
}
