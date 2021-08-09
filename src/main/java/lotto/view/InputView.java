package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String FIRST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    public int askPurchaseAmount() {
        System.out.println(FIRST_MESSAGE);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public String getWinningNumber() {
        System.out.println(ASK_WINNING_NUMBER);
        return SCANNER.nextLine();
    }

}
