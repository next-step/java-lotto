package ui;

public class ResultView {
    private static final String RESULT_MESSAGE = "계산결과: %d";

    private ResultView() {
    }

    public static void printResult(int value) {
        System.out.println(String.format(RESULT_MESSAGE, value));
    }
}
