package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.dto.RankDTO;

public class RankResult {

    private static int DEFAULT_NUMBER = 0;
    private static int AUTO_INCREMENT = 1;
    private final Map<Rank, Integer> rankResult;

    public RankResult(final Lottos lottos, final Winning winning) {
        this.rankResult = lottos.lottos().stream().collect(
            Collectors.groupingBy(arg -> Rank.countMatch(winning, arg),Collectors.summingInt(x -> AUTO_INCREMENT)));
    }

    public int getRankResult(Rank rank) {
        if(rankResult.get(rank) == null)
            return DEFAULT_NUMBER;
        return rankResult.get(rank);
    }

    public Money getTotalPrize() {
        return new Money(rankResult.entrySet().stream()
            .mapToInt(entry -> entry.getKey().getPrize(entry.getValue()).getValue())
            .sum());
    }

    public RankDTO getRankResult(Winning winning, Money purchaseMoney) {
        return new RankDTO(this, purchaseMoney);
    }

}
