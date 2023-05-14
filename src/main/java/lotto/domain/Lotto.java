package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private List<Integer> numbers = new ArrayList<>();

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchedNumber(Set<Integer> wonNumbers) {
        Set<Integer> lotto = new HashSet<>(numbers);
        lotto.retainAll(wonNumbers);
        return lotto.size();
    }
}
