package lotto.domain.lotto;

import com.sun.tools.javac.util.Pair;
import lotto.domain.matcher.LottoRank;
import lotto.domain.matcher.WinningTicket;

import java.util.List;
import java.util.Objects;

public class LottoLine {
    private final LottoNumbers lottoNumbers;

    public LottoLine(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoRank checkPrize(WinningTicket winningTicket) {
        int matchCount = lottoNumbers.countMatchNumbers(winningTicket.getLottoNumbers());
        if (matchCount == LottoRank.FIVE.getMatchCount() && winningTicket.isMatchBonusNumber(lottoNumbers)) {
            return LottoRank.of(Pair.of(matchCount, true));
        }
        return LottoRank.of(Pair.of(matchCount, false));
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
