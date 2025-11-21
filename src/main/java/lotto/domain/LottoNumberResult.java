package lotto.domain;

import lotto.domain.constant.LottoRank;

import java.util.Objects;

public class LottoNumberResult {

    private final LottoRank lottoRank;
    private final MatchCount matchCount;

    public LottoNumberResult(LottoRank lottoRank, int matchCount) {
        this(lottoRank, new MatchCount(matchCount));
    }

    public LottoNumberResult(LottoRank lottoRank, MatchCount matchCount) {
        this.lottoRank = lottoRank;
        this.matchCount = matchCount;
    }

    public void plus() {
        this.matchCount.plus();
    }

    public boolean isCountNotZero() {
        return this.matchCount.isCountNotZero();
    }

    public int multiplication() {
        return this.matchCount.multiplication(lottoRank.getPrizeMoney());
    }

    public boolean isEqualsRank(LottoRank rank) {
        return this.lottoRank == rank;
    }

    public LottoRank getLottoRank() {
        return this.lottoRank;
    }

    public int getMatchCount() {
        return this.matchCount.getValue();
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
