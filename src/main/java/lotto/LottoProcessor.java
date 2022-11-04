package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        this.lottoWinningStats = new LottoWinningStats(getWinningNumbers(inputNumbers), lotto);
    }

    public void publish(int purchaseAmount) {
        lotto.generateNumbers(purchaseAmount / AMOUNT);
        lotto.printNumbers();
    }
    public void calculateWinningStats(String inputNumbers) {
        this.lottoWinningStats = new LottoWinningStats(getWinningNumbers(inputNumbers), lotto);
        lottoWinningStats.calculateWinningStats();
        lottoWinningStats.calculateWinningCounts();
    }

    public void printWinningStats(int purchaseAmount) {
        lottoWinningStats.printWinningCounts();
        System.out.println("총 수익률은 " + lottoWinningStats.getYield(purchaseAmount) + "입니다.");
    }

    private List<Integer> getWinningNumbers(String inputNumbers) {
        String inputNumbersTrim = inputNumbers.replaceAll(" ", "");
        String[] numbersString = inputNumbersTrim.split(",");
        return Arrays.stream(numbersString).map(Integer::parseInt).collect(Collectors.toList());
    }
}
