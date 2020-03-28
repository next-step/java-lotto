package study.calculator.view;

public class ResultView {
    private static final String RESULT_PREFIX = "덧셈 결과: ";

    private ResultView() {
    }

    public static void displayResult(int result) {
        System.out.println(RESULT_PREFIX + result);
    }
}
