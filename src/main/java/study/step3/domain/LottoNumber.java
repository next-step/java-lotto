package study.step3.domain;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    public static final String LOTTO_NUMBER_SIZE_ERROR = "당첨 번호는 1 부터 45 이내 입력해주세요.";

    private final int number;

    public LottoNumber(int number) {
        checkLottoNumberRange(number);
        this.number = number;
    }

    private void checkLottoNumberRange(int result) {
        if (checkLottoNumberSize(result)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_ERROR);
        }
    }

    private boolean checkLottoNumberSize(int number) {
        return (MIN_NUMBER > number) || (MAX_NUMBER < number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
