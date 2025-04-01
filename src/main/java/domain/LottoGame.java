package domain;

import java.util.List;

import static domain.LottoMachine.generate;
import static utils.OutputView.*;

public class LottoGame {
    private final LottoNumberGenerator generator;

    public LottoGame(LottoNumberGenerator generator) {
        this.generator = generator;
    }

    public Lottos buyLotto(String amountInput, int manualLottoCount, List<String> manualLottoInput) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(Integer.parseInt(amountInput));

        int totalLottoCount = purchaseAmount.countOfLotto();
        int autoLottoCount = totalLottoCount - manualLottoCount;

        Lottos lottos = generate(autoLottoCount, generator, manualLottoInput);
        printPurchasedLottos(lottos.getValue());

        return lottos;
    }

    public void displayStatistic(String amountInput, String winningNumberInput, String bonusNumberInput, Lottos lottos) {
        WinningNumber winningNumber = new WinningNumber(winningNumberInput, bonusNumberInput);

        Ranks ranks = new Ranks(lottos.match(winningNumber));
        LottoStatistics statistics = ranks.toStatistics();

        printStatistics(statistics);
        printProfitRate(statistics.calculateProfitRate(Integer.parseInt(amountInput)));
    }
}