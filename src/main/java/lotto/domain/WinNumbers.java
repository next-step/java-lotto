package lotto.domain;

import java.util.Set;

public class WinNumbers {
    private final Lotto lotto;

    public WinNumbers(Set<Integer> numbers) {
        this.lotto = new Lotto(numbers);
    }

    public boolean contain(int number) {
        return lotto.contains(number);
    }
}
