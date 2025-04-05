package lotto.controller;

import lotto.domain.model.MatchResult;
import lotto.domain.generator.RandomLottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.domain.model.LottoNumbers;
import lotto.domain.model.LottoWallet;
import lotto.domain.service.LottoMachine;


public class LottoController {
    private final LottoMachine lottoMachine = new LottoMachine(new RandomLottoNumberGenerator());

    public void run() {
        int purchaseAmount = InputView.getPurchaseAmount();
        LottoWallet lottoWallet = purchase(purchaseAmount);

        MatchResult result = draw(lottoWallet);

        calculateProfit(purchaseAmount, result);
    }

    private LottoWallet purchase(int purchaseAmount) {
        LottoWallet lottoWallet = this.lottoMachine.buyLottos(purchaseAmount);
        ResultView.printPurchasedLottos(lottoWallet);
        return lottoWallet;
    }

    private MatchResult draw(LottoWallet lottoWallet) {
        LottoNumbers winNumbers = new LottoNumbers(InputView.getWinNumbers());
        MatchResult result = lottoWallet.countMatches(winNumbers);
        ResultView.printMatchResult(result);
        return result;
    }

    private void calculateProfit(int purchaseAmount, MatchResult result) {
        double profit = result.calculateProfit(purchaseAmount);
        ResultView.printProfit(profit);
    }
}
