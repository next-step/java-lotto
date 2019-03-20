package lotto.domain.ticket;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> numbers;

    public LottoNumbers(List<Integer> numbers) {
        if (!isLottoNumbersSize(numbers)) {
            throw new IllegalArgumentException("Lotto numbers size must be " + LOTTO_NUMBERS_SIZE);
        }

        this.numbers = convertToLottoNumbers(numbers);
    }

    private List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    int getNumberOfDuplicatedNumbers(LottoNumbers target) {
        int numberOfDuplicatedNumbers = 0;

        for (LottoNumber targetNumber : target.numbers) {
            numberOfDuplicatedNumbers += (containsLottoNumber(targetNumber) ? 1 : 0);
        }

        return numberOfDuplicatedNumbers;
    }

    private boolean containsLottoNumber(LottoNumber target) {
        return this.numbers.stream()
                .anyMatch(number -> number.equalsTo(target));
    }

    private boolean isLottoNumbersSize(List<Integer> numbers) {
        return LOTTO_NUMBERS_SIZE == numbers.size();
    }
}
