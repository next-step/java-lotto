package lotto.service.util;

public class Validation {

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private static final String NUMBER_CHECK_ERROR_MSG = "숫자만 입력 가능합니다!!!!";
    private static final String FORM_ERROR_MSG = "당첨번호는 6자리 입니다!!!!";
    private static final String RANGE_ERROR_MSG = "로또 숫자는 1~45의 숫자만 입력 가능합니다!!!!";

    private Validation() {
        throw new AssertionError();
    }

    public static void constantCheck(String orderPrice) {

        for (char c : orderPrice.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(NUMBER_CHECK_ERROR_MSG);
            }
        }
    }

    public static void lottoSizeCheck(int lottoSize) {
        if(lottoSize != LOTTO_SIZE) {
            throw new IllegalArgumentException(FORM_ERROR_MSG);
        }
    }

    public static void lottoNumberSizeCheck(int number) {
        if(number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(RANGE_ERROR_MSG);
        }
    }
}
