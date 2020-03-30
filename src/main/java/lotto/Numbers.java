package lotto;

import java.util.HashSet;
import java.util.Set;

public class Numbers {
    private int MAX_LOTTO_COUNT = 6;
    private final Set<Integer> numbers;

    public Numbers(Set<Integer> numbers) {
        this.numbers = validate(numbers);
    }

    public Set<Integer> getNumbers() {
        return new HashSet<>(numbers);
    }

    private Set<Integer> validate(Set<Integer> numbers) {
        if (numbers.size() < MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException("중복 없이 숫자를 6개 입력해주세요.");
        }
        return new HashSet<>(numbers);
    }
}
