package controller;

import domain.model.MatchResult;
import view.InputView;
import view.ResultView;
import domain.model.LottoNumbers;
import domain.model.LottoWallet;
import domain.engine.LottoMachine;
import domain.generator.RandomLottoNumberGenerator;


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
