package lotto.domain;

import java.util.Objects;
import java.util.Set;

public class WinningLotto {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(String numbers, int bonusNumber) {
        this.winningLotto = Lotto.ofComma(numbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    private void validateBonusNumber(int bonusNumber) {
        Set<LottoNumber> numbers = winningLotto.getLottoNumbers();
        if (numbers.contains(LottoNumber.of(bonusNumber))) {
            throw new IllegalArgumentException("로또 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    public Rank match(Lotto lotto) {
        return Rank.valueOf(Math.toIntExact(lotto.match(winningLotto)), lotto.isMatchBonusNumber(bonusNumber));
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
