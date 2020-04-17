package lotto.domain;

import java.util.Objects;

public class WinningLotto {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(String numbers, int bonusNumber) {
        this.winningLotto = Lotto.ofComma(numbers);
        // TODO: 보너스 번호와 로또번호는 중복x
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    public Rank match(Lotto lotto) {
        return Rank.valueOf(Math.toIntExact(lotto.match(winningLotto)), lotto.hasBonusNumber(bonusNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLotto, that.winningLotto) &&
                Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusNumber);
    }
}
