package lotto.strategy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.exception.LottoNumberException;

import static java.util.stream.Collectors.toList;

public class LottoManualStrategy implements LottoGenerationStrategy {
    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> manualNumbers;

    public LottoManualStrategy(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateDuplicates(numbers);
        this.manualNumbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null) {
            throw new LottoNumberException();
        }

        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new LottoNumberException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new LottoNumberException();
            }
        });
    }

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new LottoNumberException();
        }
    }

    @Override
    public List<Integer> generate() {
        return manualNumbers.stream()
            .sorted()
            .collect(toList());
    }
}
