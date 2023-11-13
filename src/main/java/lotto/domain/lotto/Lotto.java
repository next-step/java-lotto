package lotto.domain.lotto;

import lotto.constants.LottoConstants;
import lotto.domain.lotto.strategy.GenerateStrategy;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(GenerateStrategy strategy) {
        this.numbers = validate(strategy.generate());
        ;
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

    public static Lotto from(GenerateStrategy strategy) {
        return new Lotto(strategy);
    }
}
