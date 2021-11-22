package lotto.domain;

import calculator.PositiveNumber;

import java.util.List;

/**
 * @author han
 */
public class Lotto {
    private final List<PositiveNumber> numbers;

    public Lotto(List<PositiveNumber> numbers) {
        this.numbers = numbers;
    }

    public List<PositiveNumber> getNumbers() {
        return numbers;
    }
}
