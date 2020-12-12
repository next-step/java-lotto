package lottery.view;

import java.util.Scanner;

public final class InputViewLotteryGame {
    final static Scanner SCANNER = new Scanner(System.in);
    public static String getUserInvestAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static String getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static String getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextLine();
    }
}
