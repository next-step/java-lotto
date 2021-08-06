package lotto.view;

import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.util.stream.IntStream.range;

public class InputView {
    private static final String INPUT_PAYMENT_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPayment() {
        println(INPUT_PAYMENT_MESSAGE);
        return parseInt(SCANNER.nextLine().trim());
    }

    public static int inputManualLottoCount() {
        println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE);
        return parseInt(SCANNER.nextLine().trim());
    }

    public static String[] inputManualLottoNumbers(final int manualLottoCount) {
        println(INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE);
        return range(0, manualLottoCount)
                .mapToObj(i -> SCANNER.nextLine().trim())
                .toArray(String[]::new);
    }

    public static String inputWinningNumbers() {
        println(INPUT_WINNING_NUMBERS_MESSAGE);
        return SCANNER.nextLine().trim();
    }

    public static String inputBonusNumber() {
        println(INPUT_BONUS_NUMBER_MESSAGE);
        return SCANNER.nextLine().trim();
    }

    private static void println(String string) {
        System.out.println(string);
    }
}
