package domain;

import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final Set<Number> numbers;

    public LottoNumbers(Set<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(Set<Number> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개의 다른 값 이여야 합니다.");
        }
    }

    public Set<Number> getContainNumbers(LottoNumbers lottoWinningNumbers) {
        return lottoWinningNumbers.numbers.stream()
                .filter(this.numbers::contains)
                .collect(Collectors.toSet());
    }

    public boolean isContainBonus(Number bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    @Override public String toString() {
        return numbers.toString();
    }
}
