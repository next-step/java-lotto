package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.entity.Number;

import java.math.BigDecimal;
import java.util.Scanner;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static BigDecimal receivePurchaseAmount() {
        String input = SCANNER.nextLine();
        validate(input);
        return new BigDecimal(input);
    }

    public static Lotto receiveWinningNumbers() {
        String[] receiveNumbers = SCANNER.nextLine().replaceAll(" ", "")
                .split(",");
        Number[] numbers = new Number[receiveNumbers.length];
        for (int i = 0; i < receiveNumbers.length; i++) {
            validate(receiveNumbers[i]);
            numbers[i] = new Number(Integer.parseInt(receiveNumbers[i]));
        }
        return new Lotto(numbers);
    }

    public static void validate(String input) {
        validateNumber(input);
        validatePositiveNumber(input);
    }


    private static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException("숫자만 입력 가능합니다.");
        }
    }

    private static void validatePositiveNumber(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }
    }

}
