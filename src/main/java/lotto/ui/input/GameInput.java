package lotto.ui.input;

import lotto.ui.output.Output;
import lotto.util.StringUtils;

import java.io.InputStream;
import java.util.*;

public class GameInput implements Input {
    private final Scanner scanner;
    private final Output output;

    public GameInput(InputStream stream, Output output) {
        this.scanner = new Scanner(stream);
        this.output = output;
    }

    @Override
    public String request(String message) {
        if (StringUtils.isNotEmpty(message)) {
            response(message);
        }

        return scanner.nextLine();
    }

    @Override
    public void response(String message) {
        output.println(message);
    }
}
