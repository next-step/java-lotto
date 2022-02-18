package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.dto.RankDTO;

public class RankResult {

    private final Map<Rank, Integer> rankResult;

    public RankResult(final Lottos lottos, final Winning winning) {
        this.rankResult = lottos.lottos().stream().collect(
            Collectors.groupingBy(arg -> Rank.countMatch(winning, arg),Collectors.summingInt(x -> 1))); //TODO: rankResult가 0으로 초기화 되지 않음.
    }

    public Map<Rank, Integer> getRankResult() {
        return rankResult;
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
