package step1;

import java.util.List;

public class CalculateApplication {

    private static final InputParser inputParser = new InputParser();

    public static void main(String[] args) {
        List<String> userInputTokens = inputParser.splitUserInput(InputView.inputMathExpression());
    }
}
