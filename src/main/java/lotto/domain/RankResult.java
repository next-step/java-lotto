package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class RankResult {

    private final Map<Rank, Integer> rankResult;


    public RankResult(final Lottos lottos, final Winning winning) {
        this.rankResult = lottos.lottos().stream().collect(
            Collectors.groupingBy(arg -> Rank.countMatch(winning, arg),Collectors.summingInt(x -> 1)));
    }

    public Map<Rank, Integer> getRankResult() {
        return rankResult;
    }

    public Money getTotalPrize() {
        return new Money(rankResult.entrySet().stream()
            .mapToInt(entry -> entry.getKey().getPrize(entry.getValue()).getValue())
            .sum());
    }
}
