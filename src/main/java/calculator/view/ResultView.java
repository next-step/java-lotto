package calculator.view;

public class ResultView {

    public static final String RESULT_MESSAGE = "실행결과를 출력합니다: ";

    private ResultView() {
    }


    public static void view(final int calculate) {
        System.out.println(RESULT_MESSAGE + calculate);
    }
}
