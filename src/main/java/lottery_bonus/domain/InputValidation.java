package lottery_bonus.domain;

import java.math.BigDecimal;

public final class InputValidation {

    private static final String VALIDATION_ERROR_MESSAGE = "숫자를 입력해주세요";

    public static BigDecimal validateAmount(final String amount) {
        validateInputNumber(amount);
        return new BigDecimal(amount);
    }

    private static void validateInputNumber(final String amount){
        if(!amount.chars().allMatch(Character::isDigit)){
            throw new IllegalArgumentException(VALIDATION_ERROR_MESSAGE);
        };
    }

}
