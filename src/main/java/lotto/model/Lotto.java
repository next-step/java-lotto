package lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public Lotto(String lottoNumbers) {
        this(parse(lottoNumbers));
    }

    private void validateNumbers(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개입니다.");
        }
    }

    public Set<Integer> getLottoNumbers() {
        return numbers;
    }

    public int getMatchCount(Lotto lotto) {
        Set<Integer> intersection = new HashSet<>(this.numbers);
        intersection.retainAll(new HashSet<>(lotto.getLottoNumbers()));
        return intersection.size();
    }

    private static Set<Integer> parse(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Lotto lotto = (Lotto) o;
        return numbers.equals(lotto.numbers);
    }

    @Override
    public int hashCode() {
        return numbers.hashCode();
    }
}
