package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private static final int START_NUMBER = 1;
    private static final int LIMIT_NUMBER = 46;
    private static final String LOTTO_NUMBERS_MUST_BE_BETWEEN_ONE_TO_FOURTY_FIVE = "로또 번호는 1과 45 사이의 숫자여야만 합니다.";
    private final int number;

    public LottoNumber(int number) {
        isLottoCandidateNumber(number);
        this.number = number;
    }

    private void isLottoCandidateNumber(int number) {
        if (!isBetweenStartNumberAndLimitNumber(number)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_MUST_BE_BETWEEN_ONE_TO_FOURTY_FIVE);
        }
    }

    private boolean isBetweenStartNumberAndLimitNumber(int number) {
        return START_NUMBER <= number && number < LIMIT_NUMBER;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LottoNumber other = (LottoNumber) obj;
        return number == other.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
