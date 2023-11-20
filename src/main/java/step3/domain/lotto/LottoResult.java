package step3.domain.lotto;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResult {

    private Map<Rank, Integer> rankMap;

    public LottoResult() {
        this.rankMap = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            this.rankMap.put(rank, 0);
        }
    }

    public void increaseCount(Rank rank) {
        Integer count = rankMap.getOrDefault(rank, 0);
        rankMap.put(rank, count + 1);
    }

    public Map<Rank, Integer> getRankMap() {
        return rankMap;
    }
}
