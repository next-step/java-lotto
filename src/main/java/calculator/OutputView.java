package calculator;

public class OutputView {
    public static final String RESULT_MESSAGE_FORMAT = "Result: %d\n";

    private OutputView() {

    }

    public static void printResult(int result) {
        System.out.printf(RESULT_MESSAGE_FORMAT, result);
    }
}
