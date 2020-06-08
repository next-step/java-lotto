package lotto.domain.data;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonus;

    public WinningLotto(List<LottoNumber> winningNumbers, LottoNumber bonus) {
        validateContainLotto(winningNumbers, bonus);
        this.lotto = Lotto.of(winningNumbers);
        this.bonus = bonus;
    }

    private void validateContainLotto(List<LottoNumber> winningNumbers, LottoNumber bonus) {
        if(winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException("보너스는 당첨번호와 중복이 되면 안됩니다.");
        }
    }

    public boolean isContainBonus(Lotto lotto) {
        return lotto.getContainCount(Collections.singletonList(bonus)) > 0;
    }

    public int getContainCount(Lotto lotto) {
        return this.lotto.getContainCount(lotto.getNumbers());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return lotto.equals(that.lotto) &&
                bonus.equals(that.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonus);
    }
}
