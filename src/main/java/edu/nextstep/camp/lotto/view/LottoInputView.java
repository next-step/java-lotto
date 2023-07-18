package edu.nextstep.camp.lotto.view;

import edu.nextstep.camp.lotto.domain.LastWinLotto;
import edu.nextstep.camp.lotto.domain.Lotto;

import java.util.List;

interface LottoInputView {

    int amountInput();

    LastWinLotto lastWinLottoInput();

    int manualLottoCountInput();

    List<Lotto> manualLottoInput(int manualLottoCount);
}
