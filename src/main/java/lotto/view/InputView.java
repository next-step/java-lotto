package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import lotto.LottoMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.validator.LottoCountValidator;
import lotto.domain.validator.LottoNumberValidator;
import lotto.domain.validator.LottoValidator;
import lotto.domain.validator.PaidValidator;
import lotto.domain.validator.Validator;

public final class InputView {

    public static final String DELIMITER = ",";

    private static final String ASK_PAID = "구입금액을 입력해 주세요.";

    private static final String ASK_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";

    private static final String ASK_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    private static final String ASK_BONUS_BALL = "보너스 볼을 입력해주세요.";

    private static final String INPUT_VALUE_MESSAGE = "\n입력한 값은 %s 입니다";

    private static final String BLANK = " ";

    private static final String EMPTY = "";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int inputPurchaseCount() {
        final String amount = input(ASK_PAID, new PaidValidator());

        return Integer.parseInt(amount) / LottoMachine.PAY;
    }

    public int inputManualLottoCount() {
        return Integer.parseInt(input(ASK_MANUAL_LOTTO_COUNT, new LottoCountValidator()));
    }

    public Lotto inputWinningNumbers() {
        final String winningNumbers = input(ASK_WINNING_NUMBERS, new LottoValidator());

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
