package calculator.view;

public class ResultView {
    private static String RESULT_MESSAGE = "실행 결과";

    public static void printResult(int result) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(result);
    }
}
