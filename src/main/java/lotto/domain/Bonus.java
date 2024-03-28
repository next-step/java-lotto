package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Bonus {
    private int number;

    public Bonus(int number) {
        this.number = number;
    }

    public void checkDuplicateWithWinning(List<Integer> winNumbers) {
        if (!winNumbers.contains(this.number)) {
            return;
        }
        throw new IllegalArgumentException("당첨번호와 보너스 볼이 중복됩니다.");
    }

    public int getBonus() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bonus)) return false;
        Bonus bonus = (Bonus) o;
        return number == bonus.number;
    }

    @Override
    public int hashCode() {
        return this.number;
    }
}
