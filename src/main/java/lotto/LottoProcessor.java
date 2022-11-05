package lotto;

import java.util.Map;

import lotto.enums.Ranks;
import lotto.numbers.Lotto;
import lotto.numbers.WinningNumbers;
import lotto.views.OutputView;

public class LottoProcessor {
    public static final int PRICE = 1000;

    private final Lotto lotto;
    private final LottoWinningStats lottoWinningStats;

    public LottoProcessor(int purchaseAmount) {
        this.lotto = new Lotto(purchaseAmount / PRICE);
        this.lottoWinningStats = new LottoWinningStats(lotto);;
    }

    public void publish(int purchaseAmount) {
        lotto.generateNumbers(purchaseAmount / PRICE);
        OutputView.printNumbers(lotto);
    }
    public void calculateWinningStats(String inputNumbers, int purchaseAmount) {
        lottoWinningStats.calculateWinningStats(lotto, WinningNumbers.getNumbers(inputNumbers), purchaseAmount / PRICE);
    }

    public Map<Ranks, Integer> getRanks() {
        return this.lottoWinningStats.getRanks();
    }

    public double getYield(int purchaseCount) {
        Map<Ranks, Integer> rankingMap = this.lottoWinningStats.getRanks();
        int totalAmounts = purchaseCount * LottoProcessor.PRICE;
        int totalWinningAmounts = rankingMap.entrySet().stream()
                                            .mapToInt(entry -> entry.getKey().getRewards().intValue() * entry.getValue()).sum();

        if (rankingMap.isEmpty() || totalWinningAmounts == 0) {
            return 0;
        }
        return (double) totalWinningAmounts / totalAmounts;
    }


}
