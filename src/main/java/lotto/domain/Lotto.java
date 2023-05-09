package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int SIZE = 6;

    private final Set<Integer> numbers;

    public Lotto() {
        this(randomLottoNumbers());
    }

    public Lotto(Set<Integer> numbers) {
        if (isInvalidNumber(numbers)) {
            throw new IllegalArgumentException("로또 번호는 1 이상 45 미만이어야 합니다.");
        }
        if (isInvalidSize(numbers)) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        this.numbers = numbers;
    }

    private static TreeSet<Integer> randomLottoNumbers() {
        List<Integer> AllNumbers = IntStream.rangeClosed(MINIMUM_NUMBER, MAXIMUM_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(AllNumbers);
        return new TreeSet<>(AllNumbers.subList(0, SIZE));
    }

    private static boolean isInvalidNumber(Set<Integer> numbers) {
        return numbers.stream()
                .anyMatch(num -> num < MINIMUM_NUMBER || num > MAXIMUM_NUMBER);
    }

    private static boolean isInvalidSize(Set<Integer> numbers) {
        return numbers.size() != SIZE;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public long getMatchCount(WinNumbers winNumbers) {
        return numbers.stream()
                .filter(winNumbers::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
