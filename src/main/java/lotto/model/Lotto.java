package lotto.model;

import java.util.List;
public class Lotto {
    private static final int LOTTO_NUMBER_DIGIT = 6;
    private static final int LOTTO_NUMBER_START_RANGE = 1;
    private static final int LOTTO_NUMBER_END_RANGE = 45;

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validation(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validation(List<Integer> numbers) {
        validationNumberDigit(numbers);
        validationNumberRange(numbers);

    }

    private void validationNumberDigit(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_DIGIT) {
            throw new IllegalArgumentException();
        }
    }

    private void validationNumberRange(List<Integer> numbers) {
        numbers.forEach(number ->  {
            if(number < LOTTO_NUMBER_START_RANGE || number >LOTTO_NUMBER_END_RANGE) {
                throw new IllegalArgumentException();
            }
        });
    }


}
