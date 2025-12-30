package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sorted = new ArrayList<>(numbers);
        Collections.sort(sorted);
        this.numbers = Collections.unmodifiableList(sorted);
    }

    public List<Integer> numbers() {
        return numbers;
    }

    public int matchCount(WinningNumbers winningNumbers) {
        return (int) numbers.stream()
            .filter(winningNumbers::contains)
            .count();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 한다.");
        }
        if (numbers.stream().distinct().count() != SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없다.");
        }
        boolean outOfRange = numbers.stream().anyMatch(n -> n < 1 || n > 45);
        if (outOfRange) {
            throw new IllegalArgumentException("로또 번호는 1~45 범위여야 한다.");
        }
    }
}
