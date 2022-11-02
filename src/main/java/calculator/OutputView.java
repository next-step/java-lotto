package calculator;

public class OutputView {
    private static final String RESULT_MESSAGE_FORMAT = "Result: %d\n";

    private OutputView() {

    }

    public static void printResult(Number result) {
        System.out.printf(RESULT_MESSAGE_FORMAT, result.getValue());
    }
}
