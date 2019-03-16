package lotto.vo;

import lotto.enums.LottoRank;

public class LottoResult {
    private final int first;
    private final int second;
    private final int third;
    private final int fourth;

    public LottoResult(int[] matchCounts) {
        this.first = matchCounts[LottoRank.FIRST.getMatchCount()];
        this.second = matchCounts[LottoRank.SECOND.getMatchCount()];
        this.third = matchCounts[LottoRank.THIRD.getMatchCount()];
        this.fourth = matchCounts[LottoRank.FOURTH.getMatchCount()];
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public int getFourth() {
        return fourth;
    }
}
