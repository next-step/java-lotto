package lotto.model.wrapper;

import lotto.model.LottoBonusNumberMatchStatus;

import java.util.Objects;

public class LottoResultMatchId {

    private final WinningLottoMatchingCount matchCount;
    private final LottoBonusNumberMatchStatus lottoBonusNumberMatchStatus;

    private LottoResultMatchId(final WinningLottoMatchingCount matchCount, final LottoBonusNumberMatchStatus lottoBonusNumberMatchStatus) {
        this.matchCount = matchCount;
        this.lottoBonusNumberMatchStatus = lottoBonusNumberMatchStatus;
    }

    public static LottoResultMatchId newInstance(final WinningLottoMatchingCount matchCount, final LottoBonusNumberMatchStatus lottoBonusNumberMatchStatus) {
        return new LottoResultMatchId(matchCount, lottoBonusNumberMatchStatus);
    }

    public static LottoResultMatchId newInstance(final WinningLottoMatchingCount matchCount, final boolean matchBonusNumber) {
        return new LottoResultMatchId(matchCount, matchCount.getLottoBonusNumberMatchStatus(matchBonusNumber));
    }

    public static LottoResultMatchId newInstance(final int matchCount, final boolean matchBonusNumber) {
        return newInstance(WinningLottoMatchingCount.of(matchCount), matchBonusNumber);
    }

    public static LottoResultMatchId newInstance(final int matchCount, LottoBonusNumberMatchStatus lottoBonusNumberMatchStatus) {
        return newInstance(WinningLottoMatchingCount.of(matchCount), lottoBonusNumberMatchStatus);
    }

    public int toInt() {
        return matchCount.toInt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoResultMatchId)) return false;
        LottoResultMatchId that = (LottoResultMatchId) o;
        return Objects.equals(matchCount, that.matchCount) &&
                lottoBonusNumberMatchStatus == that.lottoBonusNumberMatchStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, lottoBonusNumberMatchStatus);
    }
}
