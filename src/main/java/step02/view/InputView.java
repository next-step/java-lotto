package step02.view;

import java.util.Scanner;

public class InputView {
    private static final String  LOTTO_BUY_PAYING_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String  LOTTO_CREATE_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static int payLotto() {
        System.out.println(LOTTO_BUY_PAYING_MESSAGE);
        return scanner.nextInt();
    }

    public static String createWinningNumber() {
        System.out.println(LOTTO_CREATE_WINNING_NUMBERS_MESSAGE);
        scanner.nextLine();
        return scanner.nextLine();
    }

}
