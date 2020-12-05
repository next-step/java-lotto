package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import lotto.LottoMachine;
import lotto.domain.Lotto;

public final class InputView {

    protected static final String ASK_PAID = "구입금액을 입력해 주세요.";

    protected static final String ASK_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    protected static final String INPUT_VALUE_MESSAGE = "\n입력한 값은 %s 입니다";

    protected static final String BLANK = " ";

    protected static final String EMPTY = "";

    protected static final String DELIMITER = ",";

    private final Scanner scanner;

    private final PaidValidator paidValidator;

    private final WinningNumbersValidator numbersValidator;

    public InputView() {
        this.scanner = new Scanner(System.in);
        this.paidValidator = new PaidValidator();
        this.numbersValidator = new WinningNumbersValidator();
    }

    public int inputPurchaseCount() {
        final String amount = input(ASK_PAID, paidValidator);

        return Integer.parseInt(amount) / LottoMachine.PAY;
    }

    public Lotto inputWinningNumbers() {
        final String winningNumbers = input(ASK_WINNING_NUMBERS, numbersValidator);

        return new Lotto(
                Arrays.stream(winningNumbers.split(DELIMITER))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );
    }

    protected String input(final String message, final Validator validator) {
        System.out.println(message);

        String input = scanner.nextLine().replace(BLANK, EMPTY);
        while (!isValid(validator, input)) {
            input = scanner.nextLine();
        }

        return input;
    }

    protected boolean isValid(final Validator validator, final String input) {
        try {
            validator.validate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + String.format(INPUT_VALUE_MESSAGE, input));
            return false;
        }
        return true;
    }
}
