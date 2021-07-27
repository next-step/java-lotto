package lotto.domain;

import java.util.List;
import lotto.domain.exception.InvalidLottoNumberException;

public class LottoNumbers {

    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        validationNumbers(numbers);
        this.numbers = numbers;
    }

    private void validationNumbers(List<Integer> numbers) {
        if (!LottoNumberFactory.isValid(numbers)) {
            throw new InvalidLottoNumberException();
        }
    }
}
