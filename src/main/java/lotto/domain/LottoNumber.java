package lotto.domain;

import java.util.List;

public class LottoNumber {
    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
        validateIfNotNull();
    }

    private void validateIfNotNull() {
        if (this.numbers == null) throw new IllegalArgumentException();
    }

    public boolean contains(Integer number){
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
