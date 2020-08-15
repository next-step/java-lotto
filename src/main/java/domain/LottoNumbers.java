package domain;

import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    private final List<Number> numbers;

    public LottoNumbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers lottoGame = (LottoNumbers) o;
        return Objects.equals(numbers, lottoGame.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "domain.LottoGame{" +
                "numbers=" + numbers +
                '}';
    }
}
