package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoProcessor {
    private final Lotto lotto;

    public LottoProcessor(Lotto lotto) {
        this.lotto = lotto;
    }

    public void printLotto() {
        lotto.generateNumbers();
        lotto.printNumbers();
    }

    public void getWinningStats(String inputNumbers) {
        LottoWinningStats lottoWinningStats = new LottoWinningStats(getWinningNumbers(inputNumbers), lotto);
        lottoWinningStats.calculateWinningStats();
        lottoWinningStats.calculateWinningCounts();
        lottoWinningStats.printWinningCounts();

        System.out.println("총 수익률은 " + lottoWinningStats.getYield() + "입니다.");
    }

    private List<Integer> getWinningNumbers(String inputNumbers) {
        String inputNumbersTrim = inputNumbers.replaceAll(" ", "");
        String[] numbersString = inputNumbersTrim.split(",");
        List<Integer> winningNumbers = Arrays.stream(numbersString).map(Integer::parseInt).collect(Collectors.toList());
        return winningNumbers;
    }
}
