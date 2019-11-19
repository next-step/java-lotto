package step2.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String AMOUNT_EXCEPTION = "금액은 0보다 작을 수 없습니다.";
    private static Scanner scanner = new Scanner(System.in);

    public static int buyTicket() {
        System.out.println(AMOUNT);
        int amount = scanner.nextInt();
        verifyInputNumber(amount, 0);
        return amount;
    }

    public static int buyManual() {
        System.out.println(MANUAL_LOTTO_COUNT);
        int manualCount = scanner.nextInt();
        verifyInputNumber(manualCount, 0);
        return manualCount;
    }

    public static List<String> buyManual(int manualLottoCount) {
        scanner.nextLine();
        System.out.println(MANUAL_LOTTO_NUMBER);
        List<String> manuals = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manuals.add(scanner.nextLine());
        }
        return manuals;
    }

    public static String inputWinningNumbers() {
        System.out.println(WINNING_NUMBER);
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println(BONUS_NUMBER);
        return scanner.nextInt();
    }

    private static void verifyInputNumber(int inputNumber, int minValue) {
        if (inputNumber < minValue) {
            throw new IllegalArgumentException(AMOUNT_EXCEPTION);
        }
    }
}
