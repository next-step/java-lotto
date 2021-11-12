package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private static final List<Integer> LOTTO_NUMBERS = Stream.iterate(1, i -> i + 1).limit(45).collect(Collectors.toList());
    private static final int DEFAULT_SELECT_COUNT = 6;
    private final List<Integer> numbers;

    // 자동 로또
    public Lotto() {
        Collections.shuffle(LOTTO_NUMBERS);
        this.numbers = LOTTO_NUMBERS.stream().limit(6).collect(Collectors.toList());
    }

    // 수동 로또
    public Lotto(Integer... numbers) {
        this(Arrays.asList(numbers));
    }

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != DEFAULT_SELECT_COUNT) {
            throw new IllegalArgumentException("로또는 6개의 번호를 입력해야 합니다.");
        }
        this.numbers = numbers;
    }

    public int hitCount(Lotto target) {
        return (int) this.numbers.stream()
                .filter(target.numbers::contains)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return numbers.containsAll(lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
