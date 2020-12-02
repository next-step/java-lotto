package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import lotto.NumberPool;

public class Lotto {

    private final Set<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new TreeSet<>(numbers);
    }

    public Lotto() {
        this.numbers = NumberPool.getLottoNumbers();
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
}
