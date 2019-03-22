package lottogame.validator;

import java.util.Optional;

import static lottogame.domain.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static lottogame.domain.LottoNumber.MINIMUM_LOTTO_NUMBER;

public class LottoNumberValidator implements Validatable<Integer> {

    @Override
    public boolean isValid(Integer target) {
        return Optional.ofNullable(target)
                        .filter(number -> number >= MINIMUM_LOTTO_NUMBER && number <= MAXIMUM_LOTTO_NUMBER)
                        .isPresent();
    }

    @Override
    public String getInvalidMessage() {
        return MINIMUM_LOTTO_NUMBER + "이상 " + MAXIMUM_LOTTO_NUMBER + "이하의 숫자를 입력하세요.";
    }
}