package lotto.domain.lotto.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.NumbersValidator;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(final String input) {
        this(NumbersValidator.validate(input));
    }

    public Numbers(final int... numbers) {
        this(Arrays.stream(numbers).mapToObj(Number::new).collect(Collectors.toList()));
    }

    public Numbers(final Numbers newNumbers) {
        this(newNumbers.getNumbers());
    }

    public Numbers(final List<Number> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public List<Number> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
