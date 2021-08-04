package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class WinningNumbers {
    private static final int WINNING_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validateCount(numbers);
        validateUnique(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(toList());
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("당첨 번호는 %d개 이어야 합니다.", WINNING_NUMBER_COUNT));
        }
    }

    private void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() > uniqueNumbers.size()) {
            throw new IllegalArgumentException("당첨 번호가 중복 되었습니다.");
        }
    }
}
