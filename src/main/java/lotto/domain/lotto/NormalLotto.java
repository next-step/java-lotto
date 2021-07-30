package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class NormalLotto {

    private final List<Integer> numbers;

    public NormalLotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getValues() {
        return Collections.unmodifiableList(numbers);
    }
}
