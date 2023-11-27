package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoController {
    public static void run() {
        Money money = LottoInputView.inputMoney();
        Lottos lottos = Lottos.from(money.lottoCount());
        LottoResultView.showLottos(lottos);

        WinningLotto winningLotto = new WinningLotto(Lotto.from(LottoInputView.inputWinningNumbers()), LottoInputView.inputBonusNumber());
        LottoResult result = lottos.match(winningLotto);

        LottoResultView.showResult(result);
        LottoResultView.shotRate(result.getRate(money));
    }
}
