package step2.domain;

import java.util.List;

public class LottoNumber {

    private List<Number> numbers;

    public LottoNumber(List<Number> numbers) {
        this.numbers = numbers;
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumber that = (LottoNumber) o;

        return numbers != null ? numbers.equals(that.numbers) : that.numbers == null;
    }

    @Override
    public int hashCode() {
        return numbers != null ? numbers.hashCode() : 0;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
