package lotto.model.wrapper;

import lotto.model.LottoBonusMatchResult;

import java.util.Objects;

public class LottoResultMatchId {

    private final LottoMatchCount matchCount;
    private final LottoBonusMatchResult lottoBonusMatchResult;

    private LottoResultMatchId(final LottoMatchCount matchCount, final LottoBonusMatchResult lottoBonusMatchResult) {
        this.matchCount = matchCount;
        this.lottoBonusMatchResult = lottoBonusMatchResult;
    }

    public static LottoResultMatchId newInstance(final LottoMatchCount matchCount, final LottoBonusMatchResult lottoBonusMatchResult) {
        return new LottoResultMatchId(matchCount, lottoBonusMatchResult);
    }

    public static LottoResultMatchId newInstance(final LottoMatchCount matchCount, final boolean matchBonusNumber) {
        return new LottoResultMatchId(matchCount, LottoBonusMatchResult.of(matchCount, matchBonusNumber));
    }

    public static LottoResultMatchId newInstance(final int matchCount, final boolean matchBonusNumber) {
        return newInstance(LottoMatchCount.of(matchCount), matchBonusNumber);
    }

    public static LottoResultMatchId newInstance(final int matchCount, LottoBonusMatchResult lottoBonusMatchResult) {
        return newInstance(LottoMatchCount.of(matchCount), lottoBonusMatchResult);
    }

    public int toInt() {
        return matchCount.toInt();
    }

    @Override
    public String toString() {
        return "lotto match count : ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoResultMatchId)) return false;
        LottoResultMatchId that = (LottoResultMatchId) o;
        return Objects.equals(matchCount, that.matchCount) &&
                lottoBonusMatchResult == that.lottoBonusMatchResult;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, lottoBonusMatchResult);
    }
}
