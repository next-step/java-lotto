package lotto.domain;

import java.util.List;
import lotto.domain.exception.InvalidLottoNumberException;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validationNumbers(numbers);
        this.numbers = numbers;
    }

    private void validationNumbers(List<Integer> numbers) {
        if (!LottoFactory.isValid(numbers)) {
            throw new InvalidLottoNumberException();
        }
    }
}
