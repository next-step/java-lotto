package lotto.domain;

import java.util.List;

public class LottoNumber {
    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        LottoNumberValidator.validate(numbers);
        this.numbers = numbers;
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
