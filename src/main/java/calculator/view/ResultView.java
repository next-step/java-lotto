package calculator.view;

public class ResultView {
    private static final String INPUT_MESSAGE = "계산할 수식을 입력해주세요 ex) 1 + 1";
    public static final String RESULT_MESSAGE = "결과값: %d\n";

    public static void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    public static void printResult(int result) {
        System.out.printf(RESULT_MESSAGE, result);
    }
}
