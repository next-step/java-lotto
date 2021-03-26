package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int START = 1;
    public static final int END = 45;
    public static final int LOTTO_NUMBER = 6;
    private static final List<Integer> range = IntStream.range(START, END + 1)
            .boxed()
            .collect(Collectors.toList());

    private List<Integer> numbers;

    public Lotto() {
        this(creatNumbers());
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static List<Integer> creatNumbers() {
        Collections.shuffle(range);
        List<Integer> numbers = new ArrayList<>(range.subList(0, LOTTO_NUMBER));
        Collections.sort(numbers);
        return numbers;
    }

    public List<Integer> numbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int matchedCount(Lotto other) {
        return (int) numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        for (int i = 0; i < LOTTO_NUMBER; i++) {
            if (!numbers.get(i).equals(lotto.numbers.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
