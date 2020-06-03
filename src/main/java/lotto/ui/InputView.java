package lotto.ui;

import java.util.Scanner;

public class InputView {

    private InputView() {}

    public static int enterPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int amount = scanner.nextInt();
        return amount;
    }

    public static String enterWinningNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumber = scanner.nextLine();
        return winningNumber;
    }

}
