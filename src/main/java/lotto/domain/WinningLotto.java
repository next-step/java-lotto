package lotto.domain;

import java.util.Objects;

public class WinningLotto {
    private final LottoNumbers winningLotteNumbers;
    private final LottoNumber bonusBall;

    private WinningLotto(final LottoNumbers winningLotteNumbers, final LottoNumber bonusBall) {
        this.winningLotteNumbers = winningLotteNumbers;
        this.bonusBall = bonusBall;
    }

    public static WinningLotto of(final LottoNumbers winningLotteNumbers, final LottoNumber bonusBall) {
        return new WinningLotto(winningLotteNumbers, bonusBall);
    }

    LottoRank match(final LottoNumbers lottoNumbers) {
        final int matchCount = lottoNumbers.analyzeMatchCount(winningLotteNumbers);
        final boolean hasBonusBall = lottoNumbers.hasBonusBall(bonusBall);
        return LottoRank.findRank(matchCount, hasBonusBall);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLotteNumbers, that.winningLotteNumbers) &&
                Objects.equals(bonusBall, that.bonusBall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotteNumbers, bonusBall);
    }
}
