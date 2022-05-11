package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> numbers;

    public Lotto() {
        this.numbers = LottoNumberGenerator.createLottoNumber();
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = LottoNumberGenerator.createLottoNumber(numbers);
    }

    public int matchCount(List<Integer> winningNumbers) {
        List<Integer> collect = numbers.stream()
                .filter(lottoNumber -> winningNumbers.stream().anyMatch(Predicate.isEqual(lottoNumber)))
                .collect(Collectors.toList());
        return collect.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return numbers.equals(lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "numbers=" + numbers + '}';
    }

}
