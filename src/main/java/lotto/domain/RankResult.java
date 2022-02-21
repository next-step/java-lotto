package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankResult {

    private static final int DEFAULT_NUMBER = 0;
    private static final int AUTO_INCREMENT = 1;
    private final Map<Rank, Integer> rankResult;

    public RankResult(final List<Lotto> lottos, final Winning winning) {
        this.rankResult = lottos.stream().collect(
            Collectors.groupingBy(arg -> Rank.countMatch(winning, arg),
                Collectors.summingInt(x -> AUTO_INCREMENT)));
    }

    public int getTotalPrize() {
        return rankResult.entrySet().stream()
            .mapToInt(entry -> entry.getKey().getPrize(entry.getValue()).getValue())
            .sum();
    }

    public int getRankResult(Rank rank) {
        if (rankResult.get(rank) == null) {
            return DEFAULT_NUMBER;
        }
        return rankResult.get(rank);
    }

}
