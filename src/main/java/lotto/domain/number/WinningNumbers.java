package lotto.domain.number;

import java.util.List;

public class WinningNumbers implements LottoNumbers {

    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        this.numbers = getValidatedNumbers(numbers);
    }

    public boolean contain(int number) {
        return this.numbers.contains(number);
    }

    @Override
    public List<Integer> getNumbers() {
        return numbers;
    }
}
