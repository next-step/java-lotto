package lotto.ui.output;

import java.io.OutputStream;
import java.io.PrintStream;

public class GameOutput implements Output {
    private PrintStream out;

    public GameOutput(OutputStream out) {
        this.out = (PrintStream) out;
    }

    @Override
    public void println(String text) {
        out.println(text);
    }

    @Override
    public void error(String text) {
        out.print(String.format("[부적합한 입력값] %s\n", text));
    }
}
