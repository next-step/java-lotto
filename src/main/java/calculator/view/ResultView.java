package calculator.view;

public class ResultView {
    private static final String CALCULRATE_RESULT = "연산 결과";
    private static final String COLON = " : ";

    public static void showResult(int resultValue) {
        String printResult = CALCULRATE_RESULT + COLON + resultValue;
        System.out.println(printResult);
    }
}
