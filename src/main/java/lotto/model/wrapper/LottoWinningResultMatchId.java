package lotto.model.wrapper;

import lotto.model.BonusNumberMatchingStatus;

import java.util.Objects;

public class LottoWinningResultMatchId {

    private final LottoNumberWinningCount matchCount;
    private final BonusNumberMatchingStatus bonusNumberMatchingStatus;

    private LottoWinningResultMatchId(final LottoNumberWinningCount matchCount, final BonusNumberMatchingStatus bonusNumberMatchingStatus) {
        this.matchCount = matchCount;
        this.bonusNumberMatchingStatus = bonusNumberMatchingStatus;
    }

    public static LottoWinningResultMatchId newInstance(final LottoNumberWinningCount matchCount, final BonusNumberMatchingStatus bonusNumberMatchingStatus) {
        return new LottoWinningResultMatchId(matchCount, bonusNumberMatchingStatus);
    }

    public static LottoWinningResultMatchId newInstance(final LottoNumberWinningCount matchCount, final boolean matchBonusNumber) {
        return new LottoWinningResultMatchId(matchCount, matchCount.getLottoBonusNumberMatchStatus(matchBonusNumber));
    }

    public static LottoWinningResultMatchId newInstance(final int matchCount, final boolean matchBonusNumber) {
        return newInstance(LottoNumberWinningCount.of(matchCount), matchBonusNumber);
    }

    public static LottoWinningResultMatchId newInstance(final int matchCount, BonusNumberMatchingStatus bonusNumberMatchingStatus) {
        return newInstance(LottoNumberWinningCount.of(matchCount), bonusNumberMatchingStatus);
    }

    public int toInt() {
        return matchCount.toInt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoWinningResultMatchId)) return false;
        LottoWinningResultMatchId that = (LottoWinningResultMatchId) o;
        return Objects.equals(matchCount, that.matchCount) &&
                bonusNumberMatchingStatus == that.bonusNumberMatchingStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, bonusNumberMatchingStatus);
    }
}
