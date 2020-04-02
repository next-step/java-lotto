package lotto.model.wrapper;

import lotto.model.LottoBonusMatchResult;

import java.util.Objects;

public class LottoResultMatchId {

    private final int matchCount;
    private final LottoBonusMatchResult lottoBonusMatchResult;

    private LottoResultMatchId(final int matchCount, final LottoBonusMatchResult lottoBonusMatchResult) {
        this.matchCount = matchCount;
        this.lottoBonusMatchResult = lottoBonusMatchResult;
    }

    public static LottoResultMatchId newInstance(final int matchCount, final LottoBonusMatchResult lottoBonusMatchResult) {
        return new LottoResultMatchId(matchCount, lottoBonusMatchResult);
    }

    public static LottoResultMatchId newInstance(final int matchCount, final boolean matchBonusNumber) {
        return new LottoResultMatchId(matchCount, LottoBonusMatchResult.of(matchCount, matchBonusNumber));
    }

    public int toInt() {
        return matchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoResultMatchId)) return false;
        LottoResultMatchId that = (LottoResultMatchId) o;
        return matchCount == that.matchCount &&
                lottoBonusMatchResult == that.lottoBonusMatchResult;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, lottoBonusMatchResult);
    }
}
