package lotto.ui;

import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);
    private InputView() {}

    public static int enterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = SCANNER.nextInt();
        return amount;
    }

    public static String enterWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumber = SCANNER.next();
        return winningNumber;
    }

}
