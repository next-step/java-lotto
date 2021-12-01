package lotto;

import stringformula.exception.DuplicateLottoNumbersException;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        checkLottoNumbersDuplication(numbers);
        this.numbers = numbers;
    }

    public void shuffleNumbers() {
        Collections.shuffle(numbers);
    }

    public LottoNumbers selectNumbers(int count) {
        return new LottoNumbers(numbers.subList(0, count)
                .stream()
                .sorted()
                .collect(Collectors.toList()));
    }

    public int matchCount(LottoNumbers winningNumbers) {
        return (int) winningNumbers.numbers
                .stream()
                .filter(this.numbers::contains)
                .count();
    }

    public List<Integer> getNumberValues() {
        return this.numbers.stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList());
    }

    private void checkLottoNumbersDuplication(List<LottoNumber> numbers) {
        Set<LottoNumber> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            throw new DuplicateLottoNumbersException();
        }
    }

    public boolean contains(LottoNumber number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return "[ " + this.numbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", "))
                + " ]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoNumbers that = (LottoNumbers) o;
        return this.numbers.containsAll(that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
