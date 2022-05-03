package study.step1.view;

public class ResultView {
    private static final String RESULT_INFORMATION_MESSAGE = "계산 결과 :: ";

    private ResultView() {
    }

    public static void print(int result) {
        System.out.println(RESULT_INFORMATION_MESSAGE + result);
    }
}
