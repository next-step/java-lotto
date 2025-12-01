package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final Set<LottoNumber> numbers;

    public Lotto(Integer... numbers) {
        this(List.of(numbers));
    }

    public Lotto(String text) {
        this(toSets(text));
    }

    public Lotto(List<Integer> numbers) {
        this(toSets(numbers));
    }

    public Lotto(Set<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 크기는 6이어야 합니다.");
        }
        this.numbers = numbers;
    }

    private static Set<LottoNumber> toSets(String text) {
        if (Objects.isNull(text)) {
            throw new IllegalArgumentException();
        }
        String[] values = text.split(",");
        return Arrays.stream(values)
                .map(value -> LottoNumber.of(value))
                .collect(Collectors.toSet());
    }

    private static Set<LottoNumber> toSets(List<Integer> numbers) {
        return numbers.stream()
                .map(value -> LottoNumber.of(value))
                .collect(Collectors.toSet());
    }

    public int match(Lotto target) {
        int count = 0;
        for (LottoNumber lottoNumber : numbers) {
            count += target.increment(lottoNumber);
        }
        return count;
    }

    int increment(LottoNumber lottoNumber) {
        if (contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    boolean contains(int lottoNumber) {
        return contains(LottoNumber.of(lottoNumber));
    }

    boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(numbers, lotto1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
