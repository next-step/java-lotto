package lotto.domain;

import lotto.exception.LottoNumberCountNotEnoughException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class LottoNumbers {

    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        Optional.ofNullable(numbers)
                .filter(nums -> nums.size() == LOTTO_NUMBER_COUNT)
                .orElseThrow(LottoNumberCountNotEnoughException::new);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

}
