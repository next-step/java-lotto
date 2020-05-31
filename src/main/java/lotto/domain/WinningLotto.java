package lotto.domain;

import java.util.Collections;
import java.util.Objects;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonus;

    public WinningLotto(String winnigNumbers, int bonus) {
        this.lotto = Lotto.fromLottoText(winnigNumbers);
        this.bonus = bonus;
        validateContainLotto(lotto, bonus);
    }

    private void validateContainLotto(Lotto lotto, int bonus) {
        if(lotto.getContainCount(Collections.singletonList(bonus)) > 0) {
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
        return bonus == that.bonus &&
                lotto.equals(that.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonus);
    }
}
