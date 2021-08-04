package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class WinningNumbers {
    private final List<WinningNumber> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validateUnique(numbers);
        this.numbers = numbers.stream()
                .map(WinningNumber::new)
                .collect(toList());
    }

    private void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() > uniqueNumbers.size()) {
            throw new IllegalArgumentException("당첨 번호가 중복 되었습니다.");
        }
    }
}
