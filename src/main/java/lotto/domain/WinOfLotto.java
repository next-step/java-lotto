package lotto.domain;

import java.util.Set;

public class WinOfLotto {
    private final Set<Integer> numbers;
    private final int bonus;

    public WinOfLotto(Set<Integer> numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    Set<Integer> getNumbers() {
        return this.numbers;
    }

    public boolean containBonusNumber(Set<Integer> numbers) {
        return numbers.contains(bonus);
    }
}
