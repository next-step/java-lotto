package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String PURCHASE_NOTICE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_NOTICE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_NOTICE = "보너스 볼을 입력해 주세요.";

    private static final int DEFAULT_PRICE = 0;
    private static final int DEFAULT_NUMBER = -1;

    public static int getMoney() {
        System.out.println(PURCHASE_NOTICE);

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return DEFAULT_PRICE;
        }
    }

    public static String getWinnerNumber() {
        System.out.println(WINNING_NUMBER_NOTICE);

        return scanner.nextLine();
    }

    public static int getBonusNumber() {
        System.out.println(BONUS_NUMBER_NOTICE);

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return DEFAULT_NUMBER;
        }
    }
}
