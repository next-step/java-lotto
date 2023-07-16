package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Long> rankCount = new EnumMap<>(Rank.class);

    public LottoResult(final List<Rank> ranks) {
        ranks.forEach(this::increaseRankCount);
    }

    public Long getCount(final Rank rank) {
        return rankCount.getOrDefault(rank, 0L);
    }

    // TODO: 이름 ratio로 변경
    // TODO: 수익률 계산 방법 변경?
    public double calculateRateOfReturn(final long money) {
        return calculateTotalPrize() / (double) money;
    }

    private long calculateTotalPrize() {
        return Arrays.stream(Rank.values())
                .mapToLong(rank -> rank.calculatePrize(getCount(rank)))
                .sum();
    }

    private void increaseRankCount(final Rank rank) {
        rankCount.put(rank, getCount(rank) + 1);
    }
}
