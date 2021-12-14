package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PURCHASE_LOTTO_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String MANUAL_LOTTO_SIZE_INPUT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String WINNING_LOTTO_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_LOTTO_NUMBER_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";

    private InputView() {
        throw new AssertionError();
    }

    public static int readPurchasingAmount() {
        System.out.println(PURCHASE_LOTTO_INPUT_MESSAGE);
        return readInteger();
    }

    public static int readManualPurchasingSize() {
        System.out.println(MANUAL_LOTTO_SIZE_INPUT_MESSAGE);
        return readInteger();
    }

    public static List<Integer> readWinningLottoNumbers() {
        System.out.println(WINNING_LOTTO_INPUT_MESSAGE);
        return winningLottoNumbers(readString());
    }

    public static int readBonusLottoNumber() {
        System.out.println(BONUS_LOTTO_NUMBER_INPUT_MESSAGE);
        return readInteger();
    }

    private static List<Integer> winningLottoNumbers(String numbers) {
        String[] convertedNumbers = numbers.replace(" ", "").split(",");
        return Arrays.stream(convertedNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String readString() {
        return SCANNER.nextLine();
    }

    private static int readInteger() {
        return Integer.parseInt(SCANNER.nextLine());
    }
}
