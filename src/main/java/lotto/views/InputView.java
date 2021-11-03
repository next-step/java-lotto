package lotto.views;

import java.util.Scanner;

public class InputView {

    private static final String QUESTION_PURCHASE_MONEY = "구입금액을 입력해 주세요.";

    public static final Scanner scanner = new Scanner(System.in);

    public static String takeMoney() {
        askQuestion(QUESTION_PURCHASE_MONEY);
        return getInput();
    }

    private static void askQuestion(String question) {
        System.out.println(question);
    }

    private static String getInput() {
        return scanner.nextLine();
    }
}
