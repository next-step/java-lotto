package step2.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final Set<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new HashSet(numbers);
    }

    public Set<LottoNumber> getNumbers() {
        return this.numbers;
    }

    public boolean contains(int winNumber) {
        return numbers.contains(winNumber);
    }
}
