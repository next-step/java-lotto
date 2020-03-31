package lotto.domain.item;

import java.util.List;
import java.util.Objects;

public class Lotto implements Item {

    protected final LottoNumbers numbers;

    public Lotto(final LottoNumbers numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("올바르지 않은 값입니다 : null");
        }
        this.numbers = new LottoNumbers(numbers);
    }

    public Lotto(final List<LottoNumber> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("올바르지 않은 값입니다 : null");
        }
        this.numbers = new LottoNumbers(numbers);
    }

    public LottoNumbers getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }


    @Override
    public String toString() {
        return numbers.toString();
    }
}
