package step2.view;

import step2.domain.Lottery;
import step2.domain.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    public static int getBonusBallNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int getManualLotteryCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String[] getManualLotteryNumbers(int manualLotteryCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        String[] numbers = new String[manualLotteryCount];

        for (int idx = 0; idx < manualLotteryCount; idx++) {
            Scanner scanner = new Scanner(System.in);
            numbers[idx] = scanner.nextLine().trim();
        }

        return numbers;
    }
}
