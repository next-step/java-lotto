package lotto.view;

import lotto.dto.AnnounceWinning;
import lotto.dto.BuyLotto;
import lotto.validator.InputValidator;

public class InputView {

    private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";

    private static final String INPUT_LOTTO_WINNING = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING_BONUS = "보너스 볼을 입력해 주세요.";

    public static BuyLotto inputBuyLotto(Input inputChannel) {
        String amount = inputChannel.input(INPUT_LOTTO_AMOUNT);
        String manualCount = inputChannel.input(INPUT_MANUAL_LOTTO_COUNT);
        InputValidator.validateBuyLotto(amount, manualCount);

        return BuyLotto.of(amount, manualCount);
    }

    public static String inputManualLotto(Input inputChannel) {
        String manualNumber = inputChannel.input(INPUT_MANUAL_LOTTO_NUMBER);
        InputValidator.validateManualNumber(manualNumber);

        return manualNumber;
    }

    public static AnnounceWinning inputWinning(Input inputChannel) {
        String input = inputChannel.input(INPUT_LOTTO_WINNING);
        String bonus = inputChannel.input(INPUT_LOTTO_WINNING_BONUS);

        InputValidator.validateWinning(input, bonus);

        return AnnounceWinning.of(input, bonus);
    }
}

