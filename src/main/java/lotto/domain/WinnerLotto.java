package lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinnerLotto {

    private final LottoNumbers winnerLottoNumbers;

    public WinnerLotto(LottoNumbers lottoNumbers) {
        this.winnerLottoNumbers = lottoNumbers;
    }

    public static WinnerLotto of(LottoNumbers lottoNumbers, List<Integer> winnerLottoNumberList) {
        return new WinnerLotto(lottoNumbers.initializedManualLottoNumber(winnerLottoNumberList));
    }

    public int winnerLottoSize() {
        return winnerLottoNumbers.getLottoNumberGroupSize();
    }

    public int findMatchingCount(Lotto lotto) {
        return lotto.countMatching(this.winnerLottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinnerLotto that = (WinnerLotto) o;
        return Objects.equals(winnerLottoNumbers, that.winnerLottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerLottoNumbers);
    }
}
