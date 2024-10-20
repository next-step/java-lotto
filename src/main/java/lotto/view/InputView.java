package lotto.view;

import java.util.Scanner;

public class InputView {
    public static int inputTotalPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return getInputInteger();
    }

    public static String inputLastWeekWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return getInputString();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return getInputInteger();
    }

    private static int getInputInteger() {
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (Exception e) {
            return 0;
        }
    }

    private static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
