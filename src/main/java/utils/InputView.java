package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT_INPUT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_INPUT_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    public String inputExpression() {
        return scanner.nextLine();
    }

    public static String inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public static int inputManualLottoCount() {
        System.out.println(MANUAL_LOTTO_COUNT_INPUT_MESSAGE);
        return toInt(scanner.nextLine());
    }

    public static List<String> inputManualLotto(int count) {
        System.out.println(MANUAL_LOTTO_INPUT_MESSAGE);
        List<String> manualLottoNumber = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            manualLottoNumber.add(scanner.nextLine());
        }
        return manualLottoNumber;
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
