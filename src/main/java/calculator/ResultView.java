package calculator;

public class ResultView {

    private ResultView() {
    }

    public static void printResult(String input, int result) {
        System.out.println("입력: " + input);
        System.out.println("결과: " + result);
    }
}
