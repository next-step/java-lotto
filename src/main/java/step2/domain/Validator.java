package step2.domain;

import java.util.Objects;

public class Validator {
    public static final String MISS_PREVIOUS_NUMBER_MSG = "지난 당첨 입력 값이 잘못입력되었습니다.";
    public static final String MISS_AMOUNT_MSG = "금액이 잘못 되었습니다.";
    public static final String MISS_BOUNS_INPUT_MSG = "보너스 입력 값이 잘못입력되었습니다.";

    public static int validateProofOfAmount(int money) {
        if (money > 1000
            && money % 1000 != 0) {
            throw new IllegalArgumentException(MISS_AMOUNT_MSG);
        }
        return money;
    }

    public static int validateLottoRangeNumber(int input) {
        if (!(input > 0 && input < 45)) {
            throw new IllegalArgumentException(MISS_BOUNS_INPUT_MSG);
        }
        return input;
    }

    public static String validateFormula(String input) {
        if (Objects.isNull(input)
            || input.trim().length() == 0) {
            throw new IllegalArgumentException(MISS_PREVIOUS_NUMBER_MSG);
        }
        return input;
    }
}
