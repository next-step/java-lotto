package domain;

import static utils.OutputView.*;

public class LottoGame {
    private final LottoNumberGenerator generator;

    public LottoGame(LottoNumberGenerator generator) {
        this.generator = generator;
    }

    public void run(String amountInput, String winningNumberInput) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(Integer.parseInt(amountInput));
        WinningNumber winningNumber = new WinningNumber(winningNumberInput);

        int lottoCount = purchaseAmount.countOfLotto();

        Lottos lottos = Lottos.generate(lottoCount, generator);
        printPurchasedLottos(lottos.getValue());

        Ranks ranks = new Ranks(lottos.match(winningNumber));
        LottoStatistics statistics = ranks.toStatistics();

        printStatistics(statistics);
        printProfitRate(statistics.calculateProfitRate(Integer.parseInt(amountInput)));
    }
}