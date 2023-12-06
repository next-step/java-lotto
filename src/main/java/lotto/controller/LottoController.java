package lotto.controller;

import lotto.domain.LottoBuyInfo;
import lotto.domain.ManualLottos;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoController {
    public static void run() {
        LottoBuyInfo buyInfo = LottoInputView.inputBuyInfo();
        ManualLottos manualLottos = LottoInputView.inputManualLottoNumbers(buyInfo.getManualCount());
        Lottos lottos = Lottos.from(buyInfo, manualLottos);
        LottoResultView.showLottos(buyInfo, lottos);

        WinningLotto winningLotto = new WinningLotto(Lotto.from(LottoInputView.inputWinningNumbers()), LottoNumber.from(LottoInputView.inputBonusNumber()));
        LottoResult result = lottos.match(winningLotto);

        LottoResultView.showResult(result);
        LottoResultView.shotRate(result.getRate(buyInfo.getMoney()));
    }
}
