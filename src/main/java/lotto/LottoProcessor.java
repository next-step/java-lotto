package lotto;

import lotto.numbers.Lotto;
import lotto.numbers.WinningNumbers;

public class LottoProcessor {
    public static final int AMOUNT = 1000;

    private final Lotto lotto;
    private LottoWinningStats lottoWinningStats;

    public LottoProcessor(int purchaseAmount) {
        this.lotto = new Lotto(purchaseAmount / AMOUNT);
        this.lottoWinningStats = null;
    }
    public LottoProcessor(Lotto lotto, String inputNumbers) {
        this.lotto = lotto;
        this.lottoWinningStats = new LottoWinningStats(lotto);
    }

    public void publish(int purchaseAmount) {
        lotto.generateNumbers(purchaseAmount / AMOUNT);
        lotto.printNumbers();
    }
    public void calculateWinningStats(String inputNumbers) {
        this.lottoWinningStats = new LottoWinningStats(lotto);
        lottoWinningStats.calculateWinningStats(WinningNumbers.getNumbers(inputNumbers));
        lottoWinningStats.calculateWinningCounts();
    }

    public void printWinningStats(int purchaseAmount) {
        lottoWinningStats.printWinningCounts();
        System.out.println("총 수익률은 " + lottoWinningStats.getYield(purchaseAmount) + "입니다.");
    }


}
