package calculator.string.view;

public class Output {
    private static final String INPUT_MESSAGE = "계산하려는 식을 입력하세요.";

    public static void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    public static void printResultMessage(int result) {
        System.out.println(result);
    }
}
