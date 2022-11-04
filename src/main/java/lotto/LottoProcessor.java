package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoProcessor {
    private final Lotto lotto;
    private LottoWinningStats lottoWinningStats;

    public LottoProcessor(Lotto lotto) {
        this.lotto = lotto;
        this.lottoWinningStats = null;
    }
    public LottoProcessor(Lotto lotto, String inputNumbers) {
        this.lotto = lotto;
        this.lottoWinningStats = new LottoWinningStats(getWinningNumbers(inputNumbers), lotto);
    }

    public void publish() {
        lotto.generateNumbers();
        lotto.printNumbers();
    }
    public void calculateWinningStats(String inputNumbers) {
        this.lottoWinningStats = new LottoWinningStats(getWinningNumbers(inputNumbers), lotto);
        lottoWinningStats.calculateWinningStats();
        lottoWinningStats.calculateWinningCounts();
    }

    public void printWinningStats() {
        lottoWinningStats.printWinningCounts();
        System.out.println("총 수익률은 " + lottoWinningStats.getYield() + "입니다.");
    }

    private List<Integer> getWinningNumbers(String inputNumbers) {
        String inputNumbersTrim = inputNumbers.replaceAll(" ", "");
        String[] numbersString = inputNumbersTrim.split(",");
        return Arrays.stream(numbersString).map(Integer::parseInt).collect(Collectors.toList());
    }
}
