package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final String REGEX = ", ";
    private static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String NUMBER_ERROR = "숫자만 입력가능합니다.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_MANUAL_COUNT_MESSAGE = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_NUMBERS_MESSAGE = "\n수동으로 구매할 번호를 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    private static String inputValue() {
        return SCANNER.nextLine();
    }

    public static int inputPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
        return inputNumberValue();
    }

    private static void validateNumber(final String inputValue) {
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_ERROR);
        }
    }

    public static Set<Integer> inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return convertToInt();
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return inputNumberValue();
    }

    public static int inputManualCount() {
        System.out.println(INPUT_MANUAL_COUNT_MESSAGE);
        return inputNumberValue();
    }

    private static int inputNumberValue() {
        String inputValue = inputValue();
        validateNumber(inputValue);
        return Integer.parseInt(inputValue);
    }

    public static List<Set<Integer>> inputManualLottos(final int manualCount) {
        System.out.println(INPUT_MANUAL_NUMBERS_MESSAGE);
        List<Set<Integer>> manualNumbers = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            manualNumbers.add(convertToInt());
        }
        return manualNumbers;
    }

    private static Set<Integer> convertToInt() {
        List<String> values = List.of(inputValue().split(REGEX));
        for (String value : values) {
            validateNumber(value);
        }
        return values.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }
}
