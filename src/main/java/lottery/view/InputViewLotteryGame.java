package lottery.view;

import java.util.Scanner;

public final class InputViewLotteryGame {
//    final static Scanner scanner = new Scanner(System.in);
    public static int getUserInvestAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String getWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
