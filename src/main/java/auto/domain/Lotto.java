package auto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final String LOTTO_NUMBER_SIZE_ERROR_TEXT = "로또 번호는 6개의 숫자로 이루어져야 합니다.";
    private static final int MAXIMUM_LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers == null || numbers.size() != MAXIMUM_LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_ERROR_TEXT);
        }
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return "" + numbers;
    }
}
