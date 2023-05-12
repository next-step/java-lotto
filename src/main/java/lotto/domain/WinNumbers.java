package lotto.domain;

import java.util.Set;

public class WinNumbers {
    private final Lotto winNumbers;

    public WinNumbers(Set<Integer> numbers) {
        this.winNumbers = new Lotto(numbers);
    }

    public long getMatchCount(Lotto lotto) {
        return lotto.getMatchCount(this.winNumbers);
    }
}
