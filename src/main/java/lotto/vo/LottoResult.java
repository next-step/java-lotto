package lotto.vo;

import lotto.enums.LottoRank;

public class LottoResult {
    private final long first;
    private final long second;
    private final long third;
    private final long fourth;

    public LottoResult(long[] matchCounts) {
        this.first = matchCounts[LottoRank.FIRST.getMatchCount()];
        this.second = matchCounts[LottoRank.SECOND.getMatchCount()];
        this.third = matchCounts[LottoRank.THIRD.getMatchCount()];
        this.fourth = matchCounts[LottoRank.FOURTH.getMatchCount()];
    }

    public long getFirst() {
        return first;
    }

    public long getSecond() {
        return second;
    }

    public long getThird() {
        return third;
    }

    public long getFourth() {
        return fourth;
    }
}
