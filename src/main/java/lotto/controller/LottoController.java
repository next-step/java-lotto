package lotto.controller;

import lotto.domain.LottoBuyInfo;
import lotto.domain.Lottos;
import lotto.domain.LottoResult;
import lotto.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoController {

    public static void run() {
        LottoBuyInfo buyInfo = LottoInputView.inputBuyInfo();
        Lottos lottos = LottoService.purchaseLotto(buyInfo);
        LottoResultView.showLottos(buyInfo, lottos);

        LottoResult result = lottos.match(LottoService.winningLotto());
        LottoResultView.showResult(result);
        LottoResultView.shotRate(result.getRate(buyInfo.getMoney()));
    }
}
