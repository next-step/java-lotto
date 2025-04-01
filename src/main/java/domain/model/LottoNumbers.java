package domain.model;

import java.util.List;

import static domain.constant.LottoConstants.*;

public class LottoNumbers {
    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
        validate();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate() {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("Lotto numbers must contain exactly 6 numbers.");
        }
        for (Integer number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("Lotto numbers must be between 1 and 45.");
            }
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("Lotto numbers must not contain duplicates.");
        }
    }
}
