package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import lotto.LottoMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottoes;
import lotto.domain.validator.LottoCountValidator;
import lotto.domain.validator.LottoNumberValidator;
import lotto.domain.validator.LottoValidator;
import lotto.domain.validator.PaidValidator;
import lotto.domain.validator.Validator;

public final class InputView {

    public static final String DELIMITER = ",";

    private static final String ASK_PAID = "구입금액을 입력해 주세요.";

    private static final String ASK_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";

    private static final String ASK_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

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
        final String amount = printMessageAndInput(ASK_PAID, new PaidValidator());

        return Integer.parseInt(amount) / LottoMachine.PAY;
    }

    public int inputManualLottoCount() {
        return Integer
                .parseInt(printMessageAndInput(ASK_MANUAL_LOTTO_COUNT, new LottoCountValidator()));
    }

    public Lottoes inputManualLottoes(int manualCount) {
        System.out.println(ASK_MANUAL_LOTTO_NUMBERS);

        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            lottoes.add(inputLottoNumbers());
        }

        return new Lottoes(lottoes);
    }

    public Lotto inputWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBERS);

        return inputLottoNumbers();
    }

    public Lotto inputLottoNumbers() {
        final String winningNumbers = input(new LottoValidator());

        return new Lotto(
                Arrays.stream(winningNumbers.split(DELIMITER))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );
    }

    public LottoNumber inputBonusBall() {
        return new LottoNumber(printMessageAndInput(ASK_BONUS_BALL, new LottoNumberValidator()));
    }

    private String printMessageAndInput(final String message, final Validator validator) {
        System.out.println(message);

        return input(validator);
    }

    private String input(final Validator validator) {
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
