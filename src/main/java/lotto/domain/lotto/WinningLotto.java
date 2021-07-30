package lotto.domain.lotto;

import java.util.Collections;
import java.util.Set;

public class WinningLotto {

    private final Set<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(Set<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public int matchNumberCount(NormalLotto lotto) {
        return Math.toIntExact(lotto.getValues().stream()
            .filter(numbers::contains)
            .count());
    }

    public boolean matchBonusNumber(NormalLotto lotto) {
        return lotto.getValues().contains(bonusNumber);
    }

    public Set<Integer> getValues() {
        return Collections.unmodifiableSet(numbers);
    }
}
