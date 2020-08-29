package step3.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoResults {

    private final List<Rank> ranks;

    public LottoResults(List<Rank> ranks) {
        this.ranks = ranks;
    }

    int calculateWinningNumbersCount(Rank rank) {
        return (int) ranks.stream()
                .filter(rank::equals)
                .count();
    }

    int calculateTotalWinnings() {
        return Arrays.stream(Rank.values())
                .map(rank -> rank.getWinningMoney() * calculateWinningNumbersCount(rank))
                .reduce(0, Integer::sum);
    }

    public Map<Rank, Integer> calculateWinningCountStatistics() {
        Map<Rank, Integer> result = new HashMap<>();
        Arrays.stream(Rank.values())
                .forEach(rank -> result.put(rank, calculateWinningNumbersCount(rank)));
        return result;
    }

    public double calculateYield(Money money) {
        return money.calculateYield(calculateTotalWinnings());
    }

}
