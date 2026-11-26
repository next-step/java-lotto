package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class Lotto {

    private static final int SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public static Lotto create() {
        List<Integer> numberPool = createNumberPool();
        Collections.shuffle(numberPool);
        return new Lotto(numberPool.subList(0, SIZE));
    }

    public Lotto(List<Integer> numbers) {
        if (hasInvalidSize(numbers)) {
            throw new IllegalArgumentException("로또 번호는 " + SIZE + "개여야 합니다: " + numbers);
        }
        if (isOutOfRange(numbers)) {
            throw new IllegalArgumentException("로또 번호는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + " 사이여야 합니다: " + numbers);
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다: " + numbers);
        }

        this.numbers = sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private boolean hasInvalidSize(List<Integer> numbers) {
        return numbers.size() != SIZE;
    }

    private boolean isOutOfRange(List<Integer> numbers) {
        return Collections.min(numbers) < MIN_NUMBER || Collections.max(numbers) > MAX_NUMBER;
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    private static List<Integer> createNumberPool() {
        return new ArrayList<>(IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER).boxed().toList());
    }
}
