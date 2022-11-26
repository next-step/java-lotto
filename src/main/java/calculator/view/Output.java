package calculator.view;

public class Output {

    public static final String QUESTION = "수식을 입력해주세요.";
    public static final String ANSWER = "결과: ";

    public static void printQuestion() {
        System.out.println(QUESTION);
    }

    public static void printAnswer(int result) {
        System.out.println(ANSWER + result);
    }
}
