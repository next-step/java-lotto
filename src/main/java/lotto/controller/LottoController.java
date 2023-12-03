package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoMoney;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoController {
    public static void run() {
        LottoMoney money = LottoInputView.inputMoney();
        Lottos lottos = Lottos.from(money.lottoCount());
        LottoResultView.showLottos(lottos);

        WinningLotto winningLotto = new WinningLotto(Lotto.from(LottoInputView.inputWinningNumbers()), LottoNumber.from(LottoInputView.inputBonusNumber()));
        LottoResult result = lottos.match(winningLotto);

        LottoResultView.showResult(result);
        LottoResultView.shotRate(result.getRate(money));
    }
}
