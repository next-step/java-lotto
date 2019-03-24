package domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {
    private Map<Rank, Long> rankGroup;

    public LottoResult(List<Rank> ranks){
        rankGroup = ranks.stream()
            .sorted(Comparator.comparing(Rank::getMatchCount))
            .collect(Collectors.groupingBy(r -> r, Collectors.counting()));
    }

    public Map<Rank, Long> getRankGroup() {
        return rankGroup;
    }

    public Integer count(Rank rank) {
        return Optional.ofNullable(rankGroup.get(rank)).orElse(0L).intValue();
    }

    public Long calculatePrizeMoney() {
        return rankGroup.keySet().stream()
            .mapToLong(r -> r.getPrizeMoney() * rankGroup.get(r))
            .sum();
    }

    public Long calculateInvestMoney() {
        return rankGroup.keySet().stream()
            .mapToLong(r -> rankGroup.get(r) * LottoMachine.LOTTO_PRICE)
            .sum();
    }

    public Double calculateProfitRate() {
        return calculatePrizeMoney().doubleValue() / calculateInvestMoney().doubleValue();
    }
}
