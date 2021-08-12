package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private List<Number> numbers = new ArrayList<>();
    private static final int FIRST = 0;
    private static final int MAX_SIZE = 6;

    public Lotto(List<Number> shuffleNumbers) {
        numbers.addAll(shuffleNumbers);

        if (!isSorted()) {
            sort();
        }
    }

    public List<Number> numbers() {
        return this.numbers;
    }

    public boolean isCreate() {
        return numbers.size() == MAX_SIZE;
    }

    public boolean isSorted() {
        Number number = numbers.get(FIRST);
        for (int i = 1; i < numbers.size(); i++) {
            Number nextNumber = numbers.get(i);
            if (number.isBiggerThan(nextNumber)) {
                return false;
            }
            number = nextNumber;
        }
        return true;
    }

    public int match(List<Number> winnerNumbers) {
        return (int) numbers.stream()
                .filter(winnerNumbers::contains)
                .count();
    }

    private void sort() {
        numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
