package calculator.view;

public class ResultView {
    private static final String RESULT_MESSAGE = "결과 값 : ";

    private ResultView() {

    }

    public static void result(int result) {
        System.out.print(RESULT_MESSAGE + result);
    }
}
