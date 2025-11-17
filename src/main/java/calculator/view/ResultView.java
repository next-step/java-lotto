package calculator.view;

public class ResultView {

    private static final String RESULT_FORMAT = "결과 : %d";

    public static void printResult(int result) {
        System.out.println(String.format(RESULT_FORMAT, result));
    }
}
