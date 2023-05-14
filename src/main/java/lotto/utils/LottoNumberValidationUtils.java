package lotto.utils;

public class LottoNumberValidationUtils {

    private static final int START_NUMBER = 1;
    private static final int LIMIT_NUMBER = 46;
    private static final String LOTTO_NUMBERS_MUST_BE_BETWEEN_ONE_TO_FOURTY_FIVE = "로또 번호는 1과 45 사이의 숫자여야만 합니다.";

    public static void isLottoCandidateNumber(int number) {
        if (!isBetweenStartNumberAndLimitNumber(number)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_MUST_BE_BETWEEN_ONE_TO_FOURTY_FIVE);
        }
    }

    private static boolean isBetweenStartNumberAndLimitNumber(int number) {
        return START_NUMBER <= number && number < LIMIT_NUMBER;
    }
}
