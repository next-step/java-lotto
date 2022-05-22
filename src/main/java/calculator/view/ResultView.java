package calculator.view;



public class ResultView {

    private static final String INSTANCE_ERROR_MESSAGE = "ResultView 클래스를 인스턴스화 할수 없습니다";

    private ResultView() {
        throw new AssertionError(INSTANCE_ERROR_MESSAGE);
    }

    public static void printCalculateResult(int result) {
        System.out.println(result);
    }
}
