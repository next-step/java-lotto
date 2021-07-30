package lotto.domain.lotto;

import java.util.Collections;
import java.util.Set;

public class NormalLotto {

    private final Set<Integer> numbers;

    public NormalLotto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public Set<Integer> getValues() {
        return Collections.unmodifiableSet(numbers);
    }
}
