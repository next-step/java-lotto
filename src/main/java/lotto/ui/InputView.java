package lotto.ui;

import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static int enterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = SCANNER.nextInt();
        SCANNER.nextLine();
        /* scanner.nextInt() 사용 후 nextLine()을 사용 시 이 전 입력(nextInt)의 개행 문자가 남아 있는 문제가 있어
        의미 없는 nextLine() 호출 */

        return amount;
    }

    public static String enterWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumber = SCANNER.nextLine();
        return winningNumber;
    }

    public static int enterBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusBall = SCANNER.nextInt();
        return bonusBall;
    }

}
