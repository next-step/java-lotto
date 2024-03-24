package domain.lotto;

import java.util.List;
import java.util.Objects;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public static WinningLotto from(List<Integer> winningIntegerList, int bonusNumber) {
        Lotto winningLotto = Lotto.from(winningIntegerList);
        LottoNumber bonusLotto = LottoNumber.from(bonusNumber);

        verifyDuplicateBonusNumberInWininngLotto(winningLotto, bonusLotto);
        return new WinningLotto(Lotto.from(winningIntegerList), LottoNumber.from(bonusNumber));
    }

    private static void verifyDuplicateBonusNumberInWininngLotto(Lotto winningLotto, LottoNumber bonusLotto) {
        if (winningLotto.contain(bonusLotto)) {
            throw new IllegalArgumentException("보너스 번호는 당첨된 번호와 중복될 수 없습니다.");
        }
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

    public LottoNumber bonusNumber() {
        return this.bonusNumber;
    }

    public Lotto lotto() {
        return this.winningLotto;
    }
}
