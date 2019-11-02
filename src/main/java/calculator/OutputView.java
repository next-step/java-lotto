package calculator;

public class OutputView {
    private static final String OUTPUT_MESSAGE_FORMAT = "결과는 : %d 입니다.";

    public static void printResult(int result) {
        System.out.println(String.format(OUTPUT_MESSAGE_FORMAT, result));
    }
}
