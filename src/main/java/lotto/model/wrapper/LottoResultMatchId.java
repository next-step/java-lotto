package lotto.model.wrapper;

import lotto.model.LottoBonusNumberMatch;

import java.util.Objects;

public class LottoResultMatchId {

    private final LottoMatchCount matchCount;
    private final LottoBonusNumberMatch lottoBonusNumberMatch;

    private LottoResultMatchId(final LottoMatchCount matchCount, final LottoBonusNumberMatch lottoBonusNumberMatch) {
        this.matchCount = matchCount;
        this.lottoBonusNumberMatch = lottoBonusNumberMatch;
    }

    public static LottoResultMatchId newInstance(final LottoMatchCount matchCount, final LottoBonusNumberMatch lottoBonusNumberMatch) {
        return new LottoResultMatchId(matchCount, lottoBonusNumberMatch);
    }

    public static LottoResultMatchId newInstance(final LottoMatchCount matchCount, final boolean matchBonusNumber) {
        return new LottoResultMatchId(matchCount, LottoBonusNumberMatch.of(matchCount, matchBonusNumber));
    }

    public static LottoResultMatchId newInstance(final int matchCount, final boolean matchBonusNumber) {
        return newInstance(LottoMatchCount.of(matchCount), matchBonusNumber);
    }

    public static LottoResultMatchId newInstance(final int matchCount, LottoBonusNumberMatch lottoBonusNumberMatch) {
        return newInstance(LottoMatchCount.of(matchCount), lottoBonusNumberMatch);
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
                lottoBonusNumberMatch == that.lottoBonusNumberMatch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, lottoBonusNumberMatch);
    }
}
