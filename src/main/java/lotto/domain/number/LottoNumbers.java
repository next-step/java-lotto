package lotto.domain.number;

import java.util.Collections;
import java.util.List;
import lotto.domain.exception.InvalidLottoNumberException;
import lotto.domain.exception.InvalidLottoNumbersSizeException;

public interface LottoNumbers {

    int LOTTO_NUMBERS_SIZE = 6;
    int FIRST_NUMBER = 1;
    int LAST_NUMBER = 45;

    default List<Integer> getValidatedNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new InvalidLottoNumbersSizeException(LOTTO_NUMBERS_SIZE);
        }

        numbers.forEach(this::validateNumber);

        return Collections.unmodifiableList(numbers);
    }

    private void validateNumber(Integer number) {
        if (number < FIRST_NUMBER || number > LAST_NUMBER) {
            throw new InvalidLottoNumberException(FIRST_NUMBER, LAST_NUMBER);
        }
    }

    List<Integer> getNumbers();

}
