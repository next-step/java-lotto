package lotto.controller;

import lotto.domain.LottoPurchase;
import lotto.domain.LottoShop;
import lotto.domain.LottoStatistics;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.LottoInputView;
import lotto.view.LottoResult;
import lotto.view.LottoResultView;

public class LottoController {

    private final LottoInputView inputView = new LottoInputView();
    private final LottoResultView resultView = new LottoResultView();

    public void run() {
        Money money = new Money(inputView.getMoney());

        LottoShop lottoShop = new LottoShop();
        LottoPurchase lottoPurchase = lottoShop.purchase(money);

        resultView.printPurchaseLotto(LottoResult.from(lottoPurchase.getLottos()));

        WinningLotto winningLotto = new WinningLotto(
                inputView.getWinningLottoNumbers(),
                inputView.getWinningLottoBonusNumber());

        LottoStatistics lottoStatistics = new LottoStatistics(winningLotto, lottoPurchase.getLottos());
        resultView.printStatistics(lottoStatistics);
        resultView.printRoi(lottoPurchase.getRoi(lottoStatistics.getTotalPrize()));
    }

}
