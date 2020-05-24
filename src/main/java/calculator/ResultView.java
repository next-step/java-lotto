package calculator;

public class ResultView {

    private static final String RESULT_MESSAGE = "정답은 : ";

    private ResultView() {
    }

    public static void printResult(Integer calculationSum) {
        System.out.println(RESULT_MESSAGE + calculationSum);
    }
}
