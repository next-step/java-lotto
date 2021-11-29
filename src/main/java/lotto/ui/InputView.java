package lotto.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String READ_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_MANUAL_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String READ_MANUAL_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String READ_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int readMoney() {
        System.out.println(READ_MONEY_MESSAGE);
        return scanner.nextInt();
    }

    public static int readManualCount() {
        System.out.println(READ_MANUAL_COUNT_MESSAGE);
        return scanner.nextInt();
    }

    public static List<String> readManualNumbers(int manualCount) {
        scanner.nextLine();
        System.out.println(READ_MANUAL_NUMBERS_MESSAGE);
        List<String> manualNumbers = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            manualNumbers.add(scanner.nextLine());
        }
        return manualNumbers;
    }

    public static String readWinningNumber() {
        System.out.println(READ_WINNING_NUMBER_MESSAGE);
        return scanner.nextLine();
    }

    public static int readBonusNumber() {
        System.out.println(READ_BONUS_NUMBER_MESSAGE);
        return scanner.nextInt();
    }
}
