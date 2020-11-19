package lotto.view;

import lotto.dto.BuyLotto;
import lotto.dto.AnnounceWinning;
import lotto.validator.InputValidator;

public class InputView {

    private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING = "지난 주 당첨 번호를 입력해 주세요.";

    public static BuyLotto inputBuyLotto(InputChannel inputChannel) {
        String amount = inputChannel.input(INPUT_LOTTO_AMOUNT);
        InputValidator.validateBuyLotto(amount);

        return BuyLotto.of(amount);
    }

    public static AnnounceWinning inputWinning(InputChannel inputChannel) {
        String input = inputChannel.input(INPUT_LOTTO_WINNING);
        InputValidator.validateWinning(input);

        return AnnounceWinning.of(input);
    }
}

