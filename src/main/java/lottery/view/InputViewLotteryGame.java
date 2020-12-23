package lottery.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class InputViewLotteryGame {
    final static Scanner SCANNER = new Scanner(System.in);
    public static String getUserInvestAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static String getNumberOfLotterysByManual() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static List<String> getUserLotteryTicketNumbersByManual(int numberOfManual) {
        List<String> lotteryNumbersByManual = new ArrayList<>();
        for (int i = 0; i < numberOfManual; i++) {
            lotteryNumbersByManual.add(SCANNER.nextLine());
        }
        return lotteryNumbersByManual;
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
