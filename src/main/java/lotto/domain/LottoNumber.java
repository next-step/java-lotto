package lotto.domain;

import lotto.util.Validator;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MINIMUM_BALL_NUMBER = 1;
    private static final int MAXIMUM_BALL_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        this.number = number;
        validateRange(number);
    }

    public LottoNumber(String numberString) {
        this(Validator.parseToInt(numberString));
    }

    public static void validateRange(final int number) {
        if (number < MINIMUM_BALL_NUMBER || number > MAXIMUM_BALL_NUMBER) {
            throw new IllegalArgumentException(
                "[ERROR] " + MINIMUM_BALL_NUMBER + "부터 " + MAXIMUM_BALL_NUMBER + "까지의 숫자만 입력해주세요.");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        if (this.number > o.getNumber()) {
            return 1;
        }
        return -1;
    }
}
