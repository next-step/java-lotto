package lotto.domain;

import lotto.util.RandomLottoNumberGenerator;

import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private final List<Integer> numbers;

    public LottoNumber() {
        this.numbers = generateRandomSortedNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private List<Integer> generateRandomSortedNumbers() {
        List<Integer> numbers = RandomLottoNumberGenerator.generate();
        Collections.sort(numbers);

        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
