package lotto.ui;

import java.util.Scanner;

public class InputView {

    private static final String READ_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int readMoney() {
        System.out.println(READ_MONEY_MESSAGE);
        return scanner.nextInt();
    }

    public static String readWinningNumber() {
        scanner.nextLine();
        System.out.println(READ_WINNING_NUMBER_MESSAGE);
        return scanner.nextLine();
    }
}
