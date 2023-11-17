package lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinningNumber {
    public static final String DUPLICATE_BONUS_NUMBER_MSG = "보너스번호는 중복될 수 없습니다.";
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningNumber(List<Integer> winningNumberList, LottoNumber bonusNumber) {
        this(new Lotto(winningNumberList), bonusNumber);
    }

    public WinningNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        validaitonNumber(winningLotto, bonusNumber);
    }

    private void validaitonNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_MSG);
        }
    }

    public int getRightNumber(Lotto lotto) {
        return winningLotto.getRightNumber(lotto);
    }

    public boolean isRightBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumber that = (WinningNumber) o;
        return bonusNumber == that.bonusNumber && Objects.equals(winningLotto, that.winningLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusNumber);
    }
}
