package study.lotto.view;

import study.lotto.domain.LottoNumber;

import java.math.BigDecimal;
import java.util.List;

public interface InputView {
    String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    String INPUT_SELF_PICK_MESSAGE = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    String INPUT_WINNING_LOTTO = "\n지난 주 당첨 번호를 입력해 주세요.";
    String INPUT_SELF_PICK_LOTTO = "\n수동으로 구매할 번호를 입력해 주세요.";
    String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    BigDecimal inputPurchaseAmount();
    String inputWinningLotto();
    LottoNumber inputBonusNumber();
    int inputSelfPickLottoCount();
    List<String> inputSelfPickLotto(int selfPickLottoCount);

}
