package lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinnerLotto {

    private final LottoNumberGroup winnerLottoNumberGroup;

    public WinnerLotto(LottoNumberGroup lottoNumberGroup) {
        this.winnerLottoNumberGroup = lottoNumberGroup;
    }

    public static WinnerLotto of(LottoNumberGroup lottoNumberGroup, List<Integer> winnerLottoNumberList) {
        return new WinnerLotto(lottoNumberGroup.initializedManualLottoNumber(winnerLottoNumberList));
    }

    public int winnerLottoSize() {
        return winnerLottoNumberGroup.getLottoNumberGroupSize();
    }

    public int findMatchingCount(Lotto lotto) {
        return lotto.countMatching(this.winnerLottoNumberGroup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinnerLotto that = (WinnerLotto) o;
        return Objects.equals(winnerLottoNumberGroup, that.winnerLottoNumberGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerLottoNumberGroup);
    }
}
