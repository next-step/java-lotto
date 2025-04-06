package autoLotto;

import java.util.Set;

public class WinningLotto extends Lotto {

    int bonus;

    public WinningLotto(Set<Integer> numbers, int bonus) {
        super(numbers);
        this.bonus = bonus;
    }

    public void validate() {
        super.validate();
        if (containsNumber(bonus)) {
            throw new IllegalArgumentException("bonus number is not equal to lotto numbers.");
        }
    }

    public boolean containsBonusNumber(int number) {
        return bonus == number;
    }
}
