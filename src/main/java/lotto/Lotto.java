package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final LottoNumbers numbers;

    public Lotto(List<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers = new LottoNumbers(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
