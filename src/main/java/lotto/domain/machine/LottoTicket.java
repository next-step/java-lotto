package lotto.domain.machine;

import com.sun.tools.javac.util.Pair;
import lotto.domain.matcher.LottoRank;
import lotto.domain.matcher.WinningTicket;
import lotto.domain.lotto.LottoNumbers;

import java.util.List;
import java.util.Objects;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
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
        if (!(o instanceof LottoTicket)) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

}
