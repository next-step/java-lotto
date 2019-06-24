package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analyzer {

    private final List<Integer> winningNumbers;
    private final Map<Prize, Integer> prizeStatus = new HashMap<>();

    public Analyzer(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void analyze(Lottos lottos) {
        List<Integer> countsOfMatchingNumbers = lottos.getCountOfMatchingNumbers(winningNumbers);
        countsOfMatchingNumbers.forEach(count -> countPrize(Prize.valueOf(count)));
    }

    private void countPrize(Prize prize) {
        int currentCount = prizeStatus.getOrDefault(prize, 0);
        prizeStatus.put(prize, currentCount + 1);
    }

    public Map<Prize, Integer> getPrizeStatus() {
        return prizeStatus;
    }
}
