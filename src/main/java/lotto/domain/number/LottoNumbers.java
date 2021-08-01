package lotto.domain.number;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.lotto.exception.InvalidLottoNumberException;

public class LottoNumbers {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private final Set<Integer> numbers;

    private LottoNumbers(Set<Integer> numbers) {
        createValidation(numbers);
        this.numbers = numbers;
    }

    private void createValidation(Set<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new InvalidLottoNumberException();
        }
    }

    public static LottoNumbers create() {
        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < LOTTO_NUMBER_COUNT) {
            randomNumbers.add(LottoNumber.create());
        }

        return new LottoNumbers(randomNumbers);
    }

    public static LottoNumbers create(Set<Integer> numbers) {
        return new LottoNumbers(numbers);
    }

    public static LottoNumbers create(List<Integer> numbers) {
        return new LottoNumbers(new HashSet<>(numbers));
    }

    public int matchCount(LottoNumbers lottoNumbers) {
        return (int) lottoNumbers.numbers.stream()
            .filter(this.numbers::contains)
            .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public Set<Integer> getValues() {
        return Collections.unmodifiableSet(numbers);
    }
}
