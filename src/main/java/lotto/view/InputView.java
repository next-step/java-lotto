package lotto.view;

import java.util.Scanner;

public class InputView {

    public static final String MSG_INPUT_PURCHASE_NUMBER = "구입금액을 입력해 주세요.";
    public static final String MSG_INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseNumber() {
        System.out.println(MSG_INPUT_PURCHASE_NUMBER);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputWinningNumber() {
        System.out.println(MSG_INPUT_WINNING_NUMBER);

        return scanner.nextLine();
    }

}
