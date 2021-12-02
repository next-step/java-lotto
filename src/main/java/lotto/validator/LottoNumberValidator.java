package lotto.validator;

import static lotto.domain.LottoNumber.BOUND_END;
import static lotto.domain.LottoNumber.BOUND_START;

public class LottoNumberValidator {
    public static void checkBound(Integer number) {
        if (number > BOUND_END) {
            throw new IllegalArgumentException(BOUND_END + "보다 큰 숫자가 입력될 수 없습니다.");
        }
        if (number < BOUND_START) {
            throw new IllegalArgumentException(BOUND_START + "보다 작은 숫자가 입력될 수 없습니다.");
        }
    }

    public static void checkNumeric(String numberString) {
        try {
            Integer.parseInt(numberString);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닙니다");
        }
    }
}
