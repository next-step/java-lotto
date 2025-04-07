package domain;

import java.util.List;

import static domain.LottoMachine.generate;
import static utils.OutputView.*;

public class LottoGame {
    private final LottoNumberGenerator generator;

    public LottoGame(LottoNumberGenerator generator) {
        this.generator = generator;
    }

    public Lottos buyLotto(int amount, int manualLottoCount, List<String> manualLottoInput) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);

        int totalLottoCount = purchaseAmount.countOfLotto();
        int autoLottoCount = totalLottoCount - manualLottoCount;

        Lottos lottos = generate(autoLottoCount, generator, manualLottoInput);
        printPurchasedLottos(lottos.getValue());

        return lottos;
    }

    public void displayStatistic(int amount, String winningNumberInput, String bonusNumberInput, Lottos lottos) {
        WinningNumber winningNumber = new WinningNumber(winningNumberInput, bonusNumberInput);

        Ranks ranks = new Ranks(lottos.match(winningNumber));
        LottoStatistics statistics = ranks.toStatistics();

        printStatistics(statistics);
        printProfitRate(statistics.calculateProfitRate(amount));
    }
}