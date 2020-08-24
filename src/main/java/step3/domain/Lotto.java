package step3.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또번호는 6개여야 합니다.");
        }
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public int findWinningNumbersCount(WinningNumbers winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::isWinningNumber)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
