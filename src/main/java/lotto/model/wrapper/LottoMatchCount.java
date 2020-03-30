package lotto.model.wrapper;

import lotto.model.LottoBonusMatchResult;

import java.util.Objects;

public class LottoMatchCount {

    private final int matchCount;
    private final LottoBonusMatchResult lottoBonusMatchResult;

    private LottoMatchCount(final int matchCount, final LottoBonusMatchResult lottoBonusMatchResult) {
        this.matchCount = matchCount;
        this.lottoBonusMatchResult = lottoBonusMatchResult;
    }

    public static LottoMatchCount newInstance(final int matchCount, final LottoBonusMatchResult lottoBonusMatchResult) {
        return new LottoMatchCount(matchCount, lottoBonusMatchResult);
    }

    public static LottoMatchCount create(final int matchCount, final boolean matchBonusNumber) {
        return new LottoMatchCount(matchCount, LottoBonusMatchResult.of(matchCount, matchBonusNumber));
    }

    public int toInt() {
        return matchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoMatchCount)) return false;
        LottoMatchCount that = (LottoMatchCount) o;
        return matchCount == that.matchCount &&
                lottoBonusMatchResult == that.lottoBonusMatchResult;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, lottoBonusMatchResult);
    }
}
