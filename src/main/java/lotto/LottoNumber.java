package lotto;

import java.util.List;
import java.util.Objects;

public class LottoNumber {

    private List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(this.numbers.stream().sorted(), that.numbers.stream().sorted());
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
