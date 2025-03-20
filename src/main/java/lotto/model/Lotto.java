package lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public Lotto(String lottoNumbers) {
        List<Integer> parsedNumbers = parse(lottoNumbers);
        validateNumbers(parsedNumbers);
        this.numbers = parsedNumbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개입니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호 중복 불가!");
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public int getMatchCount(Lotto lotto) {
        Set<Integer> intersection = new HashSet<>(this.numbers);
        intersection.retainAll( new HashSet<>(lotto.getLottoNumbers()));
        return intersection.size();
    }

    private List<Integer> parse(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()){
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
