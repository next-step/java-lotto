package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int SIZE = 6;
    private static final int MIN = 1;
    private static final int MAX = 45;

    private final Set<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateUnique(numbers);
        this.numbers = Set.copyOf(numbers);
    }

    public Lotto(int... numbers) {
        this(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
    }

    public List<Integer> numbers() {
        return numbers.stream()
            .sorted()
            .collect(Collectors.toList());
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int matchCount(Lotto winning) {
        return (int) numbers.stream()
            .filter(winning::contains)
            .count();
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 한다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(this::isOutOfRange)) {
            throw new IllegalArgumentException("로또 번호는 1~45 범위여야 한다.");
        }
    }

    private boolean isOutOfRange(int number) {
        return number < MIN || number > MAX;
    }

    private void validateUnique(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없다.");
        }
    }
}
