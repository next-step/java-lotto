package lotto;

import java.util.List;
import java.util.Objects;

public class MatchCount {

    private int matchCount;

    public MatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public void calculateWinningMatchCount(WinningLotto winningLotto, List<LottoNumber> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            this.matchCount += winningLotto.hasLottoNumber(lottoNumbers.get(i)) ? 1 : 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchCount that = (MatchCount) o;
        return matchCount == that.matchCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount);
    }
}
