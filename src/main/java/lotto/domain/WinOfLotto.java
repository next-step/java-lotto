package lotto.domain;

import java.util.Set;

public class WinOfLotto extends Lotto {
    private final int bonus;

    public WinOfLotto(Set<Integer> numbers, int bonus) {
        super(numbers);
        this.bonus = bonus;
    }

    public boolean containBonusNumber(Set<Integer> numbers) {
        return numbers.contains(bonus);
    }
}
