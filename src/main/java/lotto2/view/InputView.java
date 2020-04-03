package lotto2.view;

import java.util.Scanner;

public class InputView {
    public static final String AMOUNT_QUESTION = "구입금액을 입력해 주세요.";
    public static final String PRIZE_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    private static Scanner scanner = new Scanner(System.in);

    public long askNumberOfPurchase() {
        System.out.println(AMOUNT_QUESTION);
        return Long.parseLong(scanner.nextLine());
    }

    public String askLastPrizeNumber() {
        System.out.println(PRIZE_QUESTION);
        return scanner.nextLine();
    }


}
