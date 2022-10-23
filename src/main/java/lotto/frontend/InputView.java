package lotto.frontend;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String ENTER_MONEY = "구매 금액을 입력해주세요.";
    private static final String ENTER_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    public static int askEnterMoney() {
        System.out.println(ENTER_MONEY);
        return scanner.nextInt();
    }

    public static String askEnterWinningNumbers() {
        System.out.println(ENTER_WINNING_NUMBER);
        return scanner.next();
    }
}
