package lotto.data;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
        Collections.sort(numbers);
    }

    public int matchCount(LottoNumbers winningNumbers) {
        return (int) winningNumbers.getNumbers().stream()
                                   .filter(numbers::contains)
                                   .count();
    }

    public boolean isMatchBonus(int bonus) {
        return numbers.contains(bonus);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
