package lotto.model;

import java.util.Objects;

public class LottoNumber {

    public static final int RANGE_MAX = 45;
    public static final int RANGE_MIN = 1;
    private static final String RANGE_ERROR_MSG = "번호는 1~45사이의 자연수입니다.";

    private final int number;

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if(number < RANGE_MIN || number > RANGE_MAX){
            throw new IllegalArgumentException(RANGE_ERROR_MSG);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
