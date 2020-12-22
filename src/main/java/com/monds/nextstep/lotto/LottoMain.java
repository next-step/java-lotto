package com.monds.nextstep.lotto;

import com.monds.nextstep.lotto.domain.*;

import static com.monds.nextstep.lotto.view.LottoInputView.*;
import static com.monds.nextstep.lotto.view.LottoResultView.printLottoResult;
import static com.monds.nextstep.lotto.view.LottoResultView.printLottos;

public class LottoMain {
    public static void main(String[] args) {
        Lottos lottos = LottoMachine.purchase(purchaseAmount());
        printLottos(lottos);

        WinningLotto winningLotto = new WinningLotto(
                Lotto.of(lastWeeksWinningNumbers()), LottoNumber.of(bonusNumber()));
        LottoResult lottoResult = lottos.getLottoResult(winningLotto);
        printLottoResult(lottoResult);
    }
}
