package calculator.domain;

import calculator.view.ResultView;

import static calculator.view.InputView.inputStr;
import static calculator.view.ResultView.printResult;

public class Calculator {
    public static final String BLINK_INPUT_ERROR = "입력된 값이 없습니다.";
    private static final String DELIMETER = " ";

    public static void StartCalculate() {
        String[] inputArrays = splitInput(inputStr(ResultView::printInputMessage));
        OperationHandler operationHandler = new OperationHandler(inputArrays);
        printResult(operationHandler.calculate());
    }

    public static String[] splitInput(String input) {
        validateString(input);
        return input.split(DELIMETER);
    }

    private static void validateString(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(BLINK_INPUT_ERROR);
        }
    }

    private static boolean isBlank(String input) {
        return (input == null || input.trim().isEmpty());
    }
}
