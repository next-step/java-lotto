package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {
    private static final int SIZE = 6;
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 45;
    private static final List<Integer> baseNumbers = IntStream.rangeClosed(RANGE_START, RANGE_END).boxed().collect(Collectors.toList());

    private final TreeSet numbers;

    public Numbers() {
        Collections.shuffle(baseNumbers);
        this.numbers = new TreeSet<>(baseNumbers.subList(0, SIZE));
    }

    public Numbers(List<Integer> numbers) {
        checkArgumentValidation(numbers);
        this.numbers = new TreeSet<>(numbers);
    }

    private void checkArgumentValidation(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("Numbers의 List<Integer> size는 항상 6입니다.");
        }
        if (numbers.stream().anyMatch(integer -> integer < RANGE_START || integer > RANGE_END)) {
            throw new IllegalArgumentException("Numbers의 List<Integer> 의 멤버 Integer 값은 항상 1~45 사이 값 입니다.");
        }
    }

    public TreeSet getNumbers() {
        return this.numbers;
    }

    public int match(Numbers prizeNumbers) {
        return (int) this.numbers.stream().filter(prizeNumbers.numbers::contains).count();
    }
}
