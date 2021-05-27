package lotto.ui.input;

import lotto.ui.output.GameOutput;
import lotto.ui.output.Output;
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

    public String requestAfterNewLine(String message) {
        output.println("");

        return request(message);
    }

    public List<String> requestForMultipleValues(int count, String message) {
        List<String> answers = new ArrayList<>(Arrays.asList(requestAfterNewLine(message)));

        while (answers.size() < count) {
            answers.add(scanner.nextLine());
        }

        return answers;
    }
}
