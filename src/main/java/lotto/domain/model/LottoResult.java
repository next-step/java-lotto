package lotto.domain.model;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class LottoResult {

    private final Map<LottoRank, Integer> rankToCount;

    private LottoResult() {
        rankToCount = Stream.of(LottoRank.values())
                .collect(java.util.stream.Collectors.toMap(e -> e, e -> 0));
    }

    private LottoResult(Map<LottoRank, Integer> rankToCount) {
        this();
        this.rankToCount.putAll(rankToCount);
    }

    public static LottoResult createEmpty() {
        return new LottoResult();
    }

    public static LottoResult createFromMap(Map<LottoRank, Integer> rankToCount) {
        return new LottoResult(rankToCount);
    }

    public int getCountByRank(LottoRank lottoRank) {
        return rankToCount.get(lottoRank);
    }

    public void update(LottoRank lottoRank, int count) {
        rankToCount.put(lottoRank, rankToCount.get(lottoRank) + count);
    }

    public void update(LottoRank lottoRank) {
        update(lottoRank, 1);
    }

    public int sumWinningMoney() {
        return rankToCount.entrySet().stream().map(e -> e.getKey().getWinningMoney() * e.getValue())
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
