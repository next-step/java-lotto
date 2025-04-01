package controller;

import view.InputView;
import view.ResultView;
import domain.model.LottoNumbers;
import domain.model.LottoWallet;
import domain.engine.LottoMachine;
import domain.generator.RandomLottoNumberGenerator;

import java.util.List;


public class LottoController {
    private final LottoWallet lottoWallet = new LottoWallet();
    private final LottoMachine lottoMachine = new LottoMachine(new RandomLottoNumberGenerator());

    public void run() {
        int purchaseAmount = InputView.getPurchaseAmount();
        purchase(purchaseAmount);

        draw();

        calculateProfit(purchaseAmount);
    }

    private void purchase(int purchaseAmount) {
        List<LottoNumbers> lottoList = this.lottoMachine.buyLottos(purchaseAmount);
        ResultView.printPurchasedLottoCount(lottoList.size());
        this.lottoWallet.addLottos(lottoList);

        for (LottoNumbers lotto : this.lottoWallet.getLottos()) {
            ResultView.printLottoNumbers(lotto.getNumbers());
        }
    }

    private void draw() {
        LottoNumbers winNumbers = new LottoNumbers(InputView.getWinNumbers());
        this.lottoWallet.countMatches(winNumbers);
        ResultView.printMatchResult(this.lottoWallet.getMatchResult());
    }

    private void calculateProfit(int purchaseAmount) {
        double profit = (double) this.lottoWallet.getPrize() / purchaseAmount;
        ResultView.printProfit(profit);
    }
}
