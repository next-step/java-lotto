package calculator.view;

public class Output {

    private static final String RESULT_MESSAGE = "계산 결과는 : ";

    public static void printResult(int resultValue) {
        System.out.println(RESULT_MESSAGE + resultValue);
    }

}
