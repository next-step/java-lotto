package lotto_step3.controller;

import lotto_step3.domain.Lotto;
import lotto_step3.domain.LottoResult;
import lotto_step3.domain.Lottos;
import lotto_step3.domain.Money;
import lotto_step3.view.LottoInputView;
import lotto_step3.view.LottoResultView;

public class LottoController {
    public static void run() {
        Money money = LottoInputView.inputMoney();
        Lottos lottos = Lottos.from(money.lottoCount());
        LottoResultView.showLottos(lottos);

        Lotto winningLotto = Lotto.from(LottoInputView.inputWinningNumbers());
        LottoResult result = lottos.match(winningLotto);

        LottoResultView.showResult(result);
        LottoResultView.shotRate(result.getRate(money));
    }
}
