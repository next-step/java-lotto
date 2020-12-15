package lotto.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final Set<Integer> numbers;

    public Lotto(Integer... numbers) {
        this.numbers = Arrays.stream(numbers)
                .peek(this::validNumber)
                .collect(Collectors.toSet());
    }

    public Lotto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    private void validNumber(Integer number) {
        if(number < 1 || number > 45)
            throw new IllegalArgumentException();
    }

    public int sameNumberCount(Lotto lotto) {
        Set<Integer> resultNumbers = new HashSet<>(this.numbers);
        Set<Integer> compareNumbers = lotto.getNumbers();
        resultNumbers.retainAll(compareNumbers);
        return resultNumbers.size();
    }
}
