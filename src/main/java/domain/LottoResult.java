package domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {
    private Map<Rank, Long> rankGroup;

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto){
        rankGroup = lottos.stream()
            .map(winningLotto::matchLotto)
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
}
