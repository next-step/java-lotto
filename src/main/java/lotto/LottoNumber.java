package lotto;

import java.util.Objects;
import java.util.Set;

class LottoNumber {
    private Set<Integer> numbers;

    public LottoNumber(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof LottoNumber)) { return false; }
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(getNumbers(), that.getNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumbers());
    }
}
