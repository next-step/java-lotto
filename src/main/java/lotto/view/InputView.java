package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String PURCHASE_NOTICE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_NOTICE = "지난 주 당첨 번호를 입력해 주세요.";

    private static final int DEFAULT_PRICE = Integer.MIN_VALUE;

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

}
