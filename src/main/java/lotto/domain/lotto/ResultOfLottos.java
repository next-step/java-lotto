package lotto.domain.lotto;

import lotto.domain.Rank;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ResultOfLottos {
    private static final int NO_VALUE_FOR_MATCH_COUNT = 0;

    private final Map<Rank, Integer> resultOfLottos;

    public ResultOfLottos() {
        this.resultOfLottos = new HashMap<>();
    }

    public ResultOfLottos(Map<Rank, Integer> resultOfLottos) {
        this.resultOfLottos = resultOfLottos;
    }

    public int numberOfMatchCount(Rank rank) {
        return valueForMatchCount(rank);
    }

    public void increaseNumberOfMatchCount(Rank rank) {
        int numberOfMatchCount = valueForMatchCount(rank);
        resultOfLottos.put(rank, numberOfMatchCount + 1);
    }

    public int totalWinningMoney() {
        return resultOfLottos.keySet().stream()
                .mapToInt(rank -> rank.winningMoney() * valueForMatchCount(rank))
                .sum();
    }

    private int valueForMatchCount(Rank rank) {
        return Optional.ofNullable(resultOfLottos.get(rank))
                .orElse(NO_VALUE_FOR_MATCH_COUNT);
    }
}
