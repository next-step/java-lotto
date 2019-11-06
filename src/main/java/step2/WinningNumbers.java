package step2;

import java.util.Set;

public class WinningNumbers {
    private Set<Integer> numbers;

    public WinningNumbers(Set<Integer> winningNumbers) {
        this.numbers = winningNumbers;
    }

    public boolean contains(Integer integer) {
        return numbers.contains(integer);
    }

}
