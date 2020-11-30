package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import lotto.domain.Lotto;

public class InputView {

    public static final String BLANK = " ";

    public static final String EMPTY = "";

    private final Scanner scanner;

    private final AmountValidator amountValidator;

    private final WinningNumbersValidator numbersValidator;

    public InputView() {
        this.scanner = new Scanner(System.in);
        this.amountValidator = new AmountValidator();
        numbersValidator = new WinningNumbersValidator();
    }

    public int inputPurchaseCount() {
        String amount = scanner.nextLine();
        amountValidator.validate(amount);
        return Integer.parseInt(amount);
    }

    public Lotto inputWinningNumbers() {
        String winningNumbers = scanner.nextLine().replace(BLANK, EMPTY);
        numbersValidator.validate(winningNumbers);
        return new Lotto(
                Arrays.stream(winningNumbers.split(BLANK))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );
    }
}
