package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.exception.InvalidLottoNumberException;

public abstract class Lotto {

    protected final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validationNumbers(numbers);
        this.numbers = numbers;
    }

    private void validationNumbers(List<Integer> numbers) {
        if (!LottoFactory.isValid(numbers)) {
            throw new InvalidLottoNumberException();
        }
    }

    public List<Integer> getValues() {
        return Collections.unmodifiableList(numbers);
    }
}
