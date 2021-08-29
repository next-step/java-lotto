package lotto.number;

import java.util.List;
import java.util.Objects;

public class LottoNumbers {

    public static final int NUMBERS_LENGTH = 6;
    private final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        isValid(numbers);
        this.numbers = numbers;
    }

    public List<LottoNumber> value() {
        return this.numbers;
    }

    private void isValid(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException("로또 숫자는 6개입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers lottoNumbers1 = (LottoNumbers) o;
        return Objects.equals(numbers, lottoNumbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    public int matchOfWinningNumbers(WinningNumbers winningNumbers) {
        return (int) winningNumbers.value().stream()
                .filter(this.numbers::contains)
                .count();
    }
}
