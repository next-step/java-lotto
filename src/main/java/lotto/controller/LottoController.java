package lotto.controller;

import lotto.domain.LottoPurchase;
import lotto.domain.LottoShop;
import lotto.view.LottoStatistics;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

import java.util.List;

public class LottoController {

    private final LottoInputView inputView = new LottoInputView();
    private final LottoResultView resultView = new LottoResultView();
    private final LottoShop lottoShop = new LottoShop();

    public void run() {
        Money money = new Money(inputView.getMoney());
        List<List<Integer>> lottoManualNumbers = inputView.getLottoManualNumbers();

        LottoPurchase lottoPurchase = lottoShop.purchase(money, lottoManualNumbers);

        resultView.printPurchaseLotto(lottoPurchase);

        WinningLotto winningLotto = new WinningLotto(
                inputView.getWinningLottoNumbers(),
                inputView.getWinningLottoBonusNumber());

        LottoStatistics lottoStatistics = new LottoStatistics(winningLotto, lottoPurchase.getLottos());
        resultView.printStatistics(lottoStatistics);
        resultView.printRoi(lottoPurchase.getRoi(lottoStatistics.getTotalPrize()));
    }

}
