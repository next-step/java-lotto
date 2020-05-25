package calculator.view;

public class ResultView {

    private static final String RESULT_MESSAGE = "정답 : ";

    private ResultView() {
    }

    public static void printResult(Integer calculationSum) {
        System.out.println(RESULT_MESSAGE + calculationSum);
    }
}
