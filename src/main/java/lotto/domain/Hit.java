package lotto.domain;

import java.util.HashMap;
import java.util.Map;

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
            Statistics statistics = Statistics.getStatistics(matchCount);
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
}
