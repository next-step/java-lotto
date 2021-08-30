package lottery_auto.domain;

import java.math.BigDecimal;

public final class InputValidation {

    private static final String VALIDATION_ERROR_MESSAGE = "금액을 입력해주세요";

    public static BigDecimal validateAmount(String amount) {
        validateInputType(amount);
        return new BigDecimal(amount);
    }

    private static void validateInputType(String amount){
        if(!amount.chars().allMatch(Character::isDigit)){
            throw new IllegalArgumentException(VALIDATION_ERROR_MESSAGE);
        };
    }
}
