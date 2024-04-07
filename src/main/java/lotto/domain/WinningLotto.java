package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WinningLotto {
    private final Lotto winNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> winNumbers, int bonusNumber) {
        checkBonusDuplicate(winNumbers, bonusNumber);
        this.winNumbers = new Lotto(winNumbers);
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    public LottoNumber getBonusNumber() {
        return this.bonusNumber;
    }

    public Lotto getWinNumbers() {
        return this.winNumbers;
    }

    private void checkBonusDuplicate(List<Integer> winNumbers, int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호와 보너스 번호가 중복됩니다.");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof WinningLotto)) return false;
        WinningLotto that = (WinningLotto) object;
        return Objects.equals(winNumbers, that.winNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winNumbers, bonusNumber);
    }
}
