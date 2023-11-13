package lotto.domain.lotto;

import lotto.constants.LottoConstants;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private final List<Integer> numbers;

    private LottoNumbers(List<Integer> numbers) {
        this.numbers = new ArrayList<>(validate(numbers)) ;
    }

    public static LottoNumbers of(List<Integer> numbers) {
        return new LottoNumbers(numbers);
    }

    private List<Integer> validate(List<Integer> numbers) {
        validateCount(numbers);

        for (Integer number : numbers) {
            validateRange(number);
        }

        return numbers;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoConstants.NUMBER_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateRange(Integer number) {
        if (number < LottoConstants.NUMBER_MIN || number > LottoConstants.NUMBER_MAX) {
            throw new IllegalArgumentException(LottoConstants.NUMBER_ERROR_MESSAGE);
        }
    }
}
