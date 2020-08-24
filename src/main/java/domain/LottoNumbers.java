package domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<Number> numbers;

    public LottoNumbers(List<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Number> numbers) {
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개의 다른 값 이여야 합니다.");
        }
    }

    public List<Number> getContainNumbers(LottoNumbers lottoWinningNumbers) {
        return lottoWinningNumbers.numbers.stream()
                .filter(this.numbers::contains)
                .collect(Collectors.toList());
    }

    public boolean isContainBonus(Number bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    @Override public String toString() {
        return numbers.toString();
    }
}
