package StringCalculator.frontend;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    private static final Scanner scanner = new Scanner(System.in);
    private static final String ENTER_NUMBER_SENTENCE = "산식을 입력해주세요 : ";

    public static String askNumberSentence() {
        System.out.println(ENTER_NUMBER_SENTENCE);
        return scanner.nextLine();
    }
}
