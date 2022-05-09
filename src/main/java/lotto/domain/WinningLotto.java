package lotto.domain;

import java.util.Objects;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        validateWinningValue(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    WinningLotto(Lotto winningLotto, int bonusNumber) {
        this(winningLotto, new LottoNumber(bonusNumber));
    }

    public Lotto getWinningLotto() {
        return this.winningLotto;
    }

    public LottoNumber getBonusNumber() {
        return this.bonusNumber;
    }

    private void validateWinningValue(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto == null || bonusNumber == null) {
            throw new IllegalArgumentException(String.format("당첨 로또 혹은 보너스 번호는 null 일 수 없습니다. 입력받은 값 (당첨 로또 번호 : %s, 보너스 번호 : %s)", winningLotto, bonusNumber));
        }
        if (containsBonusNumber(winningLotto, bonusNumber)) {
            throw new IllegalArgumentException(String.format("보너스 번호는 당첨 번호와 중복일 수 없습니다. 입력받은 값 (당첨 로또 번호 : %s, 보너스 번호 : %s)", winningLotto, bonusNumber));
        }
    }

    private boolean containsBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        return winningLotto.containsBonusNumber(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WinningLotto that = (WinningLotto) o;

        if (!Objects.equals(winningLotto, that.winningLotto)) return false;
        return Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        int result = winningLotto.hashCode();
        result = 31 * result + bonusNumber.hashCode();
        return result;
    }
}
