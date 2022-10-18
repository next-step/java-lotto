package lotto.expressions;

public class LottoNumberExpression {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private static final String INVALID_LOTTO_NUMBER_BOUND_MESSAGE = "로또 번호는 1 ~ 45 의 숫자만 가능합니다.";

    private LottoNumberExpression() {
    }

    public static void validateNumber(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_BOUND_MESSAGE);
        }
    }
}
