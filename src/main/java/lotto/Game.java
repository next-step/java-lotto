package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final List<Integer> numbers;

    public static final int DIGIT = 6;

    public Game(List<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != DIGIT) {
            throw new IllegalArgumentException("로또는 " + DIGIT + "자리여야 합니다.");
        }

        if (numbers.stream().anyMatch(it -> it < 1 || it > 45)) {
            throw new IllegalArgumentException("로또는 1~45 사이의 숫자여야 합니다.");
        }
    }

    public long countMatches(List<Integer> winningNumbers) {
        return numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
