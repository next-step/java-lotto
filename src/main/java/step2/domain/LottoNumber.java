package step2.domain;

import java.util.List;

public class LottoNumber {

    private static final String NEGATIVE_NUMBER_EXCEPTION = "로또번호에 음수는 올 수 없습니다.";

    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        validateLottoNumber(numbers);
        this.numbers = numbers;
    }

    private void validateLottoNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION);
            }
        }

    }


}
