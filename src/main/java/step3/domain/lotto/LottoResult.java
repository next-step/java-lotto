package step3.domain.lotto;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> rankMap;

    public LottoResult() {
        this.rankMap = new LinkedHashMap<>();
        initLottoResult();
    }

    public void initLottoResult() {
        Arrays.stream(Rank.values()).forEach(rank -> this.rankMap.put(rank, 0));
    }

    public LottoResult(final List<Rank> rankList) {
        this();
        rankList.stream().forEach(rank -> increaseCount(rank));
    }

    public void increaseCount(final Rank rank) {
        Integer count = rankMap.getOrDefault(rank, 0);
        rankMap.put(rank, count + 1);
    }

    public Map<Rank, Integer> getRankMap() {
        return rankMap;
    }
}
