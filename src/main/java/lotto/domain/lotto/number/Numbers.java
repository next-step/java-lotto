package lotto.domain.lotto.number;

import java.util.ArrayList;
import java.util.List;
import lotto.util.NumbersValidator;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(String input) {
        this.numbers = NumbersValidator.validate(input);
    }

    public Numbers(List<Number> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public Numbers(Numbers numbers) {
        this.numbers = numbers.getNumbers();
    }

    public List<Number> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
