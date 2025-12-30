package lotto;

import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private final Set<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        new Lotto(numbers); // 규칙 재사용
        this.numbers = Set.copyOf(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
