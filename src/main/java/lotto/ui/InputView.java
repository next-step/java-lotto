package lotto.ui;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.error.ErrorMessage;
import lotto.lotto.Lotto;
import lotto.lotto.LottoNumber;
import lotto.shop.Money;

public class InputView {
    public static final String NUMBER_DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Money inputMoneyAmount() {
        String input = SCANNER.nextLine();
        return new Money(toInteger(input));
    }

    public static Set<LottoNumber> inputWinningNumber() {
        String input = SCANNER.nextLine();
        String[] winningNumber = input.split(NUMBER_DELIMITER);
        checkAnswer(winningNumber);
        return Arrays.stream(winningNumber)
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    private static int toInteger(String input) {
        return Integer.parseInt(input);
    }

    private static void checkAnswer(String[] winningNumber) {
        if (winningNumber.length != Lotto.MAX_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ANSWER);
        }
    }
}
