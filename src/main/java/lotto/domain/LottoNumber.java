package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumber {
    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int matchCount(LottoNumber other) {
        List<Integer> numbers = new ArrayList<>(this.numbers);
        numbers.retainAll(other.numbers);
        return numbers.size();
    }

    public List<Integer> numbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        LottoNumber lottoNumber = (LottoNumber) o;
        return numbers.containsAll(lottoNumber.numbers) && lottoNumber.numbers.containsAll(numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    public int count() {
        return numbers == null ? 0 : numbers.size();
    }
}
