package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import lotto.LottoMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public final class InputView {

    static final String DELIMITER = ",";

    private static final String ASK_PAID = "구입금액을 입력해 주세요.";

    private static final String ASK_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    private static final String ASK_BONUS_BALL = "보너스 볼을 입력해주세요.";

    private static final String INPUT_VALUE_MESSAGE = "\n입력한 값은 %s 입니다";

    private static final String BLANK = " ";

    private static final String EMPTY = "";

    private final Scanner scanner;

    private final PaidValidator paidValidator;

    private final LottoValidator numbersValidator;

    public InputView() {
        this.scanner = new Scanner(System.in);
        this.paidValidator = new PaidValidator();
        this.numbersValidator = new LottoValidator();
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

    public LottoNumber inputBonusBall() {
        return new LottoNumber(input(ASK_BONUS_BALL, new LottoNumberValidator()));
    }

    private String input(final String message, final Validator validator) {
        System.out.println(message);

        String input = scanner.nextLine().replace(BLANK, EMPTY);
        while (!isValid(validator, input)) {
            input = scanner.nextLine();
        }

        return input;
    }

    private boolean isValid(final Validator validator, final String input) {
        try {
            validator.validate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + String.format(INPUT_VALUE_MESSAGE, input));
            return false;
        }
        return true;
    }
}
