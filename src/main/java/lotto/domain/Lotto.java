package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(Integer... numbers) {
        this(Arrays.asList(numbers));
    }

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개 숫자여야 합니다.");
        }
        this.numbers = numbers;
    }

    public long getEqualNumberCountFrom(Lotto lotto) {
        return lotto.numbers.stream().mapToLong(this::traverseCompareTo).sum();
    }

    private long traverseCompareTo(Integer comparingNumber) {
        return this.numbers.stream().filter(number -> number == comparingNumber).count();
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

    public List<Integer> copyLottoNumbers() {
        return new ArrayList<>(numbers);
    }
}
