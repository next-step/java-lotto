package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int SIZE = 6;

    private final Set<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateUnique(numbers);
        validateRangeByValueObject(numbers);
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

    private void validateUnique(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없다.");
        }
    }

    private void validateRangeByValueObject(List<Integer> numbers) {
        numbers.forEach(LottoNumber::of);
    }
}
