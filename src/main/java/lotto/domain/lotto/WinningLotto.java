package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto implements Lotto {
    private List<Integer> numbers;

    public WinningLotto(List<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public int checkMatchNumbers(BasicLotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    @Override
    public String toString() {
        return numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", ", "[", "]"));
    }
}
