package controller;

import view.InputView;
import view.ResultView;
import domain.model.LottoNumbers;
import domain.model.LottoWallet;
import domain.engine.LottoMatchCounter;
import domain.engine.LottoMachine;
import domain.generator.RandomLottoNumberGenerator;

import java.util.List;
import java.util.Map;


public class LottoController {
    private final LottoWallet lottoWallet = new LottoWallet();
    private final LottoMachine lottoMachine = new LottoMachine(new RandomLottoNumberGenerator());
    private LottoMatchCounter lottoMatchCounter;

    public void run() {
        int purchaseAmount = InputView.getPurchaseAmount();
        purchase(purchaseAmount);

        LottoNumbers winNumbers = draw();

        Map<Integer, Integer> matchResult = announce(winNumbers);

        calculateProfit(matchResult, purchaseAmount);
    }

    private void purchase(int purchaseAmount) {
        List<LottoNumbers> lottoList = this.lottoMachine.buyLottos(purchaseAmount);
        ResultView.printPurchasedLottoCount(lottoList.size());
        this.lottoWallet.addLottos(lottoList);

        for (LottoNumbers lotto : this.lottoWallet.getLottos()) {
            ResultView.printLottoNumbers(lotto.getNumbers());
        }
    }

    private LottoNumbers draw() {
        return new LottoNumbers(InputView.getWinNumbers());
    }

    private Map<Integer, Integer> announce(LottoNumbers winNumbers) {
        this.lottoMatchCounter = new LottoMatchCounter(winNumbers);
        Map<Integer, Integer> matchResult = this.lottoMatchCounter.countMatches(lottoWallet.getLottos());
        ResultView.printMessage("당첨 통계");
        ResultView.printMessage("---------");
        for (int matchCount : matchResult.keySet()) {
            ResultView.printMatchCount(
                    matchCount,
                    LottoMatchCounter.MATCH_PRICES.getOrDefault(matchCount, 0),
                    matchResult.getOrDefault(matchCount, 0)
            );
        }
        return matchResult;
    }

    private void calculateProfit(Map<Integer, Integer> matchResult, int purchaseAmount) {
        double profit = this.lottoMatchCounter.calculateProfit(matchResult, purchaseAmount);
        ResultView.printMessage(String.format("총 수익률은 %.2f 입니다.", profit));
    }
}
