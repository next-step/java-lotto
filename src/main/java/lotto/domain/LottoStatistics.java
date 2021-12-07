package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private static final Map<Integer, Integer> winningStandard = new HashMap<>();
    private Person person;
    private List<Integer> winningNumber;

    static {
        winningStandard.put(3, 5000);
        winningStandard.put(4, 50000);
        winningStandard.put(5, 1500000);
        winningStandard.put(6, 2000000000);
    }

    public LottoStatistics(Person person, List<Integer> winningNumber) {
        this.person = person;
        this.winningNumber = winningNumber;
    }

    public int winningAmount(int count) {
        return winningStandard.getOrDefault(count, 0);
    }

    public int matchedLottoNumberCount(int count) {
        Map<Integer, Integer> result = person.findWinningResult(winningNumber);
        return result.getOrDefault(count, 0);
    }

}
