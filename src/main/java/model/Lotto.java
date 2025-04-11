package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> numbers() {
        return numbers;
    }

    public int matchingCount(Lotto winningLotto) {
        Set<Integer> copy = new HashSet<>(this.numbers);
        copy.retainAll(winningLotto.numbers);
        return copy.size();
    }

    public int size() {
        return numbers.size();
    }
}
