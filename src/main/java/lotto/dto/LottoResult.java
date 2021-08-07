package lotto.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lotto.domain.model.LottoRank;

public class LottoResult {

    private final Map<LottoRank, Integer> rankToCount = new HashMap<>();

    private LottoResult() {
    }

    private LottoResult(Map<LottoRank, Integer> rankToCount) {
        this.rankToCount.putAll(rankToCount);
    }

    public static LottoResult empty() {
        return new LottoResult();
    }

    public static LottoResult of(Map<LottoRank, Integer> rankToCount) {
        return new LottoResult(rankToCount);
    }

    public void add(LottoRank lottoRank) {
        int count = rankToCount.getOrDefault(lottoRank, 0);
        rankToCount.put(lottoRank, count + 1);
    }

    public int getCountByRank(LottoRank lottoRank) {
        return rankToCount.getOrDefault(lottoRank, 0);
    }

    public int totalPrizeMoney() {
        return rankToCount.entrySet()
                .stream()
                .map(e -> e.getKey().getWinningMoney() * e.getValue())
                .reduce(0, Integer::sum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoResult)) {
            return false;
        }
        LottoResult that = (LottoResult) o;
        return Objects.equals(rankToCount, that.rankToCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankToCount);
    }
}
