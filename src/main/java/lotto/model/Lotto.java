package lotto.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final Set<LottoNumber> numbers;

    public Lotto(Set<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public Lotto(List<String> lottoNumbers) {
        this(parse(lottoNumbers));
    }

    private void validateNumbers(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개입니다.");
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return numbers;
    }

    public int getMatchCount(Lotto lotto) {
        Set<LottoNumber> intersection = this.numbers;
        intersection.retainAll(lotto.getLottoNumbers());
        return intersection.size();
    }

    private static Set<Integer> parse(List<String> lottoNumbers) {
        return lottoNumbers.stream()
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
