package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final String LOTTO_INIT_ERROR_MESSAGE = "로또 숫자 개수는 6개 이어야 합니다!";
    public static final int LOTTO_LENGTH = 6;
    public static final String NUMBER_SEPERATOR = ",";
    private final Set<Number> numbers;

    public Lotto(int... numbers) {
        this(Set.of(Arrays.stream(numbers).mapToObj(Number::new).toArray(Number[]::new)));
    }

    public Lotto(List<Integer> numbers) {
        this(Set.of(numbers.stream().map(Number::new).toArray(Number[]::new)));
    }

    public Lotto(String text) {
        this(Set.of(Arrays.stream(text.split(NUMBER_SEPERATOR)).map(Number::new).toArray(Number[]::new)));
    }

    public Lotto(Set<Number> numbers) {
        if (!isLength(numbers, LOTTO_LENGTH)) {
            throw new IllegalArgumentException(LOTTO_INIT_ERROR_MESSAGE);
        }
        this.numbers = numbers;
    }

    private boolean isLength(Set<Number> numbers,  int length) {
        return numbers.size() == length;
    }

    public boolean match(Lotto winningLotto, long count) {
        long cnt = this.numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();

        return cnt == count;
    }

    @Override
    public String toString() {
        return "[" + numbers.stream()
                        .sorted(Comparator.comparingInt(Number::getNumber))
                        .map(Number::toString)
                        .collect(Collectors.joining(NUMBER_SEPERATOR))
                + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }
}
