package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberTokens {

    List<Integer> numbers;

    public NumberTokens(int... numbers) {
        this(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
    }

    public NumberTokens(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
