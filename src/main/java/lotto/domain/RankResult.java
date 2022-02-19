package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankResult {

    private static int DEFAULT_NUMBER = 0;
    private static int AUTO_INCREMENT = 1;
    private final Map<Rank, Integer> rankResult;

    public RankResult(final List<Lotto> lottos, final Winning winning) {
        this.rankResult = lottos.stream().collect(
            Collectors.groupingBy(arg -> Rank.countMatch(winning, arg),
                Collectors.summingInt(x -> AUTO_INCREMENT)));
    }

    public int getRankResult(Rank rank) {
        if (rankResult.get(rank) == null) {
            return DEFAULT_NUMBER;
        }
        return rankResult.get(rank);
    }

    public Money getTotalPrize() {
        return new Money(rankResult.entrySet().stream()
            .mapToInt(entry -> entry.getKey().getPrize(entry.getValue()).getValue())
            .sum());
    }

}
