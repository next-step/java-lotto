package stringCalculator.view;

public class ResultView {

    private static String RESULT_MESSAGE = "결과 : ";

    public ResultView() {}

    public void result(int result) {
        System.out.println(RESULT_MESSAGE + result);
    }
}
