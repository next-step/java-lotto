package lotto.domain;

import java.util.HashMap;
import java.util.Map;

class RankMap {

    private Map<Prize, Integer> rankMap;

    public RankMap() {
        this.rankMap = new HashMap<>();
        initRankMap(this.rankMap);
    }

    private void initRankMap(Map<Prize, Integer> rankMap) {
        for (Prize value : Prize.values()) {
            rankMap.put(value, 0);
        }
    }

    public RankCount getCount(Prize prize) {
        return new RankCount(rankMap.get(prize));
    }

    public void putCount(Prize prize, RankCount rankCount) {
        rankMap.put(prize, rankCount.getCount());
    }
}
