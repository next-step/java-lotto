package lotto.ui.input;

import lotto.ui.output.GameOutput;
import lotto.ui.output.Output;
import java.io.InputStream;
import java.util.Scanner;

public class GameInput implements Input {
    private Scanner scanner;
    private Output output;

    public GameInput(InputStream stream, Output output) {
        this.scanner = new Scanner(stream);
        this.output = output;
    }

    @Override
    public String request(String message) {
        response(message);

        return scanner.nextLine();
    }

    @Override
    public void response(String message) {
        output.println(message);
    }

    public void alertWarn(String message) {
        output.error(message);
        output.println(String.format("다시 입력해 주시기 바랍니다.", GameOutput.NEW_LINE));
    }
}
