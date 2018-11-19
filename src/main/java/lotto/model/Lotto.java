package lotto.model;

import lotto.LottoConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private Set<LottoNumber> numbers;

    private Lotto(Set<Integer> numbers) {
        if (numbers.size() != LottoConstants.QUANTITY) {
            throw new IllegalArgumentException();
        }
        this.numbers = numbers.stream()
            .map(mapper -> LottoNumber.from(mapper.intValue()))
            .collect(Collectors.toSet());
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(new HashSet<>(numbers));
    }

    public int getMatchCount(Lotto targetLotto) {
        return (int) numbers.stream()
                .filter(number -> targetLotto.isContain(number))
                .count();
    }

    public boolean isContain(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
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
        return Objects.hash(numbers);
    }
}
