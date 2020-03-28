package lotto;

import java.util.Objects;
import java.util.Set;

class LottoNumber {
    private static final int WINNING_NUMBER_SIZE = 6;

    private Set<Integer> numbers;

    public LottoNumber(Set<Integer> numbers) {
        validateWinningNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateWinningNumbers(Set<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException("다른 숫자를 여섯개 입력해주세요.");
        }
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
