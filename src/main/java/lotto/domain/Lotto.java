package lotto.domain;

import java.util.*;

public class Lotto {
    private List<Integer> numbers = new ArrayList<>();

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Lotto() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        this.numbers = numbers.subList(0, 6);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchedNumber(Set<Integer> wonNumbers) {
        Set<Integer> lotto = new HashSet<>(numbers);
        lotto.retainAll(wonNumbers);
        return lotto.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
