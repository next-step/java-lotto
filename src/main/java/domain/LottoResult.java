package domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Long> rankCount = new EnumMap<>(Rank.class);

    public LottoResult(final List<Rank> ranks) {
        ranks.forEach(this::increaseRankCount);
    }

    private long calculateTotalPrize() {
        return Arrays.stream(Rank.values())
                .mapToLong(this::calculatePrize)
                .sum();
    }

    private long calculatePrize(final Rank rank) {
        return rank.getPrize() * getCount(rank);
    }

    private void increaseRankCount(final Rank rank) {
        rankCount.put(rank, getCount(rank) + 1);
    }

    public Long getCount(final Rank rank) {
        return rankCount.getOrDefault(rank, 0L);
    }

    // TODO: 이름 ratio로 변경
    // TODO: 수익률 계산 방법 변경?
    public double calculateRateOfReturn(final long money) {
        return calculateTotalPrize() / (double) money;
    }
}
