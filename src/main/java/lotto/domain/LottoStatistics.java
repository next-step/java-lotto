package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private static final Map<Integer, Integer> winningStandard = new HashMap<>();
    private final Person person;
    private final LottoResult lottoResult;

    static {
        winningStandard.put(3, 5000);
        winningStandard.put(4, 50000);
        winningStandard.put(5, 1500000);
        winningStandard.put(6, 2000000000);
    }

    public LottoStatistics(Person person, List<Integer> winningNumber) {
        this.person = person;
        this.lottoResult = person.lottoResult(winningNumber);
    }

    public int winningAmount(int count) {
        return winningStandard.getOrDefault(count, 0);
    }

    public int numberOfWinningLotto(int matchedWinningCount) {
        return lottoResult.numberOfLotto(matchedWinningCount);
    }

    public double profitRate() {
        double result = (double) lottoResult.totalWinningAmount(winningStandard) / person.amount();
        return Math.floor(result * 100) / 100.0;
    }

}
