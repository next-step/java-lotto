package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String QUESTION_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public static int inputMoney() {
        System.out.println(QUESTION_PURCHASE_AMOUNT);
        return scanner.nextInt();
    }
}
