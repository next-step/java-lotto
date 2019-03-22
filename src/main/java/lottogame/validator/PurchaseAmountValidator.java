package lottogame.validator;

import java.util.Optional;

import static lottogame.domain.PurchaseAmount.LOTTO_PRICE;

public class PurchaseAmountValidator implements Validatable<Long> {

    @Override
    public boolean isValid(Long target) {
        return Optional.ofNullable(target)
                        .filter(number -> number >= LOTTO_PRICE && number < Long.MAX_VALUE)
                        .isPresent();
    }

    @Override
    public String getInvalidMessage() {
        return LOTTO_PRICE + "원 이상의 금액을 입력 해 주세요.";
    }
}