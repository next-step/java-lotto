package lotto.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final Set<Integer> numbers;

    public Lotto(Integer... numbers) {
        this.numbers = Arrays.stream(numbers)
                .peek(this::validNumber)
                .collect(Collectors.toSet());
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    private void validNumber(Integer number) {
        if(number < 1 || number > 45)
            throw new IllegalArgumentException();
    }
}
