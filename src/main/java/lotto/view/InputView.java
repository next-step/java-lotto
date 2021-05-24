package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.entity.Number;

import java.math.BigDecimal;
import java.util.Scanner;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static BigDecimal receivePurchaseAmount() {
        return new BigDecimal(SCANNER.nextLine());
    }

    public static Lotto receiveWinningNumbers() {
        String[] receiveNumbers = SCANNER.nextLine().replaceAll(" ", "")
                .split(",");
        Number[] numbers = new Number[receiveNumbers.length];
        for (int i = 0; i < receiveNumbers.length; i++) {
            numbers[i] = new Number(Integer.parseInt(receiveNumbers[i]));
        }
        return new Lotto(numbers);
    }

}
