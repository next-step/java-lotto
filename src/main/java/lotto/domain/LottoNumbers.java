package lotto.domain;

import java.util.Collections;
import java.util.Set;

public class LottoNumbers {
    private final Set<Integer> numbers;

    public LottoNumbers(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean contains(Integer number){
        return numbers.contains(number);
    }

    public Set<Integer> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }
}
