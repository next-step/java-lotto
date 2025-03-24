package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoShop;
import lotto.domain.LottoStatistics;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoController {

    private final LottoInputView inputView = new LottoInputView();
    private final LottoResultView resultView = new LottoResultView();

    public void run() {
        Money money = new Money(inputView.getMoney());

        LottoShop lottoShop = new LottoShop();
        LottoPurchase lottoPurchase = lottoShop.purchase(money);

        resultView.printPurchaseLotto(lottoPurchase.getLottos());

        WinningLotto winningLotto = new WinningLotto(inputView.getWinningLotto());

        LottoStatistics lottoStatistics = new LottoStatistics(winningLotto, lottoPurchase.getLottos());
        resultView.printStatistics(lottoStatistics);
        resultView.printRoi(lottoPurchase.getRoi(lottoStatistics.getTotalPrize()));
    }

}
