package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final List<Number> LOTTO_NUMBER_LIST = IntStream.rangeClosed(1, 45)
        .boxed()
        .map(Number::new)
        .collect(Collectors.toList());

    private final List<Number> numbers;

    public Lotto(List<Number> numbers) {
        this.numbers = sorted(validList(unDuplicate(numbers)));
    }

    private List<Number> unDuplicate(List<Number> numbers) {
        Set<Number> set = Set.copyOf(numbers);
        List<Number> ret = new ArrayList<>();
        for (Number number : set) {
            ret.add(number);
        }
        return ret;
    }

    public static Lotto nextRandom(List<Number> numbers) {
        return new Lotto(sorted(subList(shuffled(numbers))));
    }

    private static List<Number> subList(List<Number> numbers) {
        return numbers.subList(0, LOTTO_NUMBER_COUNT);
    }

    private static List<Number> shuffled(List<Number> numbers) {
        Collections.shuffle(numbers);
        return numbers;
    }

    private static List<Number> sorted(List<Number> result) {
        Collections.sort(result, Lotto::compare);
        return result;
    }

    private static int compare(Number a, Number b) {
        if (a.value() > b.value()) {
            return 1;
        }
        if (a.value() < b.value()) {
            return -1;
        }
        return 0;
    }

    public static Lotto purchase() {
        return nextRandom(LOTTO_NUMBER_LIST);
    }

    private List<Number> validList(List<Number> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(
                "로또는 " + LOTTO_NUMBER_COUNT + "개의 중복되지않은 숫자로만 구성 가능합니다 : " + numbers.size());
        }
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    public List<Number> numbers() {
        return new ArrayList<>(numbers);
    }

}
