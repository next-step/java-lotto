package lotto.domain.lotto;

import lotto.constants.LottoConstants;
import lotto.domain.lotto.strategy.GenerateStrategy;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(GenerateStrategy strategy) {
        this.numbers = strategy.generate();
        validation();
    }

    private void validation() {

        for (Integer number : numbers) {
            System.out.println("number = " + number);
            if (number < LottoConstants.NUMBER_MIN || number > LottoConstants.NUMBER_MAX) {
                throw new IllegalArgumentException(LottoConstants.NUMBER_ERROR_MESSAGE);
            }
        }

    }

    public static Lotto from(GenerateStrategy strategy) {
        return new Lotto(strategy);
    }
}
