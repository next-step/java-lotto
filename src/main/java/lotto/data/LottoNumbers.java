package lotto.data;

import java.util.List;

public class LottoNumbers {
    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int matchCount(LottoNumbers winningNumbers) {
        return (int) winningNumbers.getNumbers().stream()
                                   .filter(numbers::contains)
                                   .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
