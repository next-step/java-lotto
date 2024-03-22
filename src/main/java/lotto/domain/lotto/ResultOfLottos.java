package lotto.domain.lotto;

import lotto.domain.Rank;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ResultOfLottos {
    private static final int NO_VALUE_FOR_MATCH_COUNT = 0;

    private final Map<Integer, Integer> resultOfLottos;

    public ResultOfLottos() {
        this.resultOfLottos = new HashMap<>();
    }

    public ResultOfLottos(Map<Integer, Integer> resultOfLottos) {
        this.resultOfLottos = resultOfLottos;
    }

    public int numberOfMatchCount(int matchCount) {
        return valueForMatchCount(matchCount);
    }

    public void increaseNumberOfMatchCount(int matchCount) {
        int numberOfMatchCount = valueForMatchCount(matchCount);
        resultOfLottos.put(matchCount, numberOfMatchCount + 1);
    }

    public int totalWinningMoney() {
        return resultOfLottos.keySet()
                .stream()
                .reduce(0, (totalWinningMoney, matchCount) -> totalWinningMoney + (Rank.findRank(matchCount).winningMoney() * valueForMatchCount(matchCount)));
    }

    private int valueForMatchCount(int matchCount) {
        return Optional.ofNullable(resultOfLottos.get(matchCount))
                .orElse(NO_VALUE_FOR_MATCH_COUNT);
    }
}
