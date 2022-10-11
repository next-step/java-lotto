package lotto;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        if (Objects.isNull(numbers) || numbers.size() != 6) {
            throw new IllegalArgumentException("로또 숫자는 6개이여야 합니다.");
        }

        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return numbers.equals(lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
