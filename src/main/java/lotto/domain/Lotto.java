package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public long matchNumberCnt(Lotto winningLotto) {
        return numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lotto lotto = (Lotto) o;

        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return numbers != null ? numbers.hashCode() : 0;
    }


}
