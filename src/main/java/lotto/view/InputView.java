package lotto.view;

import lotto.domain.number.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String PURCHASE_PRICE_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String LOTTO_NUMBER_DELIMITER = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPurchasePrice() {
        return inputInt(PURCHASE_PRICE_MESSAGE);
    }

    public static List<LottoNumber> inputWinningNumbers() {
        String winningNumbers = inputString(WINNING_NUMBERS_MESSAGE);

        return Arrays.stream(winningNumbers.split(LOTTO_NUMBER_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        return inputInt(BONUS_NUMBER_MESSAGE);
    }

    private static String inputString(final String message) {
        System.out.println();
        System.out.println(message);
        return SCANNER.nextLine();
    }

    private static int inputInt(final String message) {
        System.out.println(message);
        return Integer.parseInt(SCANNER.nextLine());
    }
}
