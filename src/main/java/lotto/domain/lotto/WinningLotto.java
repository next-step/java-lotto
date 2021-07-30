package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class WinningLotto {

    private final List<Integer> numbers;

    public WinningLotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int matchNumberCount(NormalLotto lotto) {
        return Math.toIntExact(lotto.getValues().stream()
            .filter(numbers::contains)
            .count());
    }

    public List<Integer> getValues() {
        return Collections.unmodifiableList(numbers);
    }
}
