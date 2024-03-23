package domain.lotto;

import java.util.List;
import java.util.Objects;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public static WinningLotto from(List<Integer> winningIntegerList, int bonusNumber) {
        return new WinningLotto(Lotto.from(winningIntegerList), LottoNumber.from(bonusNumber));
    }

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLotto, that.winningLotto) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusNumber);
    }
}
