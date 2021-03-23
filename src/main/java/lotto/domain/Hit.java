package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Hit {
    private final Map<Statistics, Integer> hit;
    private static final int ZERO = 0;
    private static final int MINIMUN_MATCH_COUNT = 3;

    public Hit() {
        this.hit = new HashMap<>();
        initHitMap();
    }

    private void initHitMap() {
        hit.put(Statistics.THREE, ZERO);
        hit.put(Statistics.FOUR, ZERO);
        hit.put(Statistics.FIVE, ZERO);
        hit.put(Statistics.SIX, ZERO);
    }

    public void hittingLottoStatistics(int matchCount) {
        if (matchCount >= MINIMUN_MATCH_COUNT) {
            Statistics statistics = Statistics.getStatisticsByMatchCount(matchCount);
            hit.computeIfPresent(statistics, (match, hitCount) -> hitCount + 1);
        }
    }

    public long getTotalWinningAmount() {
        long sum = 0L;
        for (Map.Entry<Statistics, Integer> hitEntrySet : hit.entrySet()) {
            if (hitEntrySet.getValue() != ZERO) {
                sum += hitEntrySet.getKey().getMoney() * hitEntrySet.getValue().longValue();
            }
        }
        return sum;
    }

    public Map<Statistics, Integer> getHit() {
        return hit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hit hit1 = (Hit) o;
        return Objects.equals(hit, hit1.hit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hit);
    }
}
