package lotto.domain.lotto;

import lotto.domain.rank.LottoRank;
import lotto.domain.rank.LottoTier;
import lotto.domain.rank.WinningLotto;

import java.util.List;
import java.util.Objects;

public class LottoLine {
    private final LottoNumbers lottoNumbers;

    LottoLine(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoRank checkPrize(WinningLotto winningLotto) {
        int matchCount = lottoNumbers.countMatchNumbers(winningLotto.getLottoNumbers());
        if (matchCount == LottoRank.FIVE.getMatchCount() && winningLotto.isMatchBonusNumber(lottoNumbers)) {
            return LottoRank.of(LottoTier.of(matchCount, true));
        }
        return LottoRank.of(LottoTier.of(matchCount, false));
    }

    public List<Integer> toIntNumbers() {
        return lottoNumbers.toIntNumbers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoLine)) return false;
        LottoLine that = (LottoLine) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

}
