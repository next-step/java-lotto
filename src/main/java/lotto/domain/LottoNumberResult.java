package lotto.domain;

import java.util.Objects;

public class LottoNumberResult {

    private final LottoRank lottoRank;
    private int matchCount;

    public LottoNumberResult(LottoRank lottoRank, int matchCount) {
        this.lottoRank = lottoRank;
        this.matchCount = matchCount;
    }

    public void plus() {
        this.matchCount += 1;
    }

    public boolean isCountNotZero() {
        return this.matchCount != 0;
    }

    public int multiplication() {
        return this.matchCount * lottoRank.getPrizeMoney();
    }

    public boolean isEqualsRank(LottoRank rank){
        return this.lottoRank == rank;
    }

    public LottoRank getLottoRank() {
        return lottoRank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumberResult that = (LottoNumberResult) o;
        return matchCount == that.matchCount && lottoRank == that.lottoRank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoRank, matchCount);
    }

    @Override
    public String toString() {
        return "LottoNumberResult{" +
                "lottoRank=" + lottoRank +
                ", matchCount=" + matchCount +
                '}';
    }
}
