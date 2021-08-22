package Lotto.Number;

import java.util.List;
import java.util.Objects;

public class Numbers {

    public static final int NUMBERS_LENGTH = 6;
    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        isValid(numbers);
        this.numbers = numbers;
    }

    private void isValid(List<Number> lottoNumbers) {
        if (lottoNumbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException("로또 숫자는 6개입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
