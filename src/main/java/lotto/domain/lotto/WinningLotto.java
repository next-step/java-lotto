package lotto.domain.lotto;

import java.util.Collections;
import java.util.Set;

public class WinningLotto {

    private final Set<Integer> numbers;

    public WinningLotto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public int matchNumberCount(NormalLotto lotto) {
        return Math.toIntExact(lotto.getValues().stream()
            .filter(numbers::contains)
            .count());
    }

    public Set<Integer> getValues() {
        return Collections.unmodifiableSet(numbers);
    }
}
