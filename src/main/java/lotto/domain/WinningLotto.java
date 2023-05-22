package lotto.domain;

import lotto.domain.result.LottoResult;
import lotto.domain.result.Rank;

import java.util.List;
import java.util.Objects;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(List<LottoNumber> lotto, int bonusNumber) {
        this.winningLotto = new Lotto(lotto);
        this.bonusNumber = bonusNumber;
    }

    private Rank getRank(Lotto lotto) {
        return Rank.valueOf(lotto.getHitCount(winningLotto), lotto.containsBonusNumber(bonusNumber));
    }

    public LottoResult getLottoResult(List<Lotto> lottoList) {
        LottoResult lottoResult = LottoResult.of();
        for (Lotto lotto : lottoList) {
            lottoResult.plusWinOfCount(getRank(lotto));
        }
        return lottoResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return bonusNumber == that.bonusNumber && Objects.equals(winningLotto, that.winningLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusNumber);
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "winningLotto=" + winningLotto +
                ", bonusNumber=" + bonusNumber +
                '}';
    }
}
