package lotto.service.value;

import lotto.utils.Preconditions;

import java.util.Objects;

public class LottoNumber {
    private static final Integer MINIMUM_NUMBER = 1;
    private static final Integer MAXIMUM_NUMBER = 45;

    private final Integer number;

    private LottoNumber(Integer number) {
        Preconditions.checkNotNull(number, "number는 필수값 입니다.");
        Preconditions.checkMinimumNumber(number, MINIMUM_NUMBER, String.format("%s 값 이상이어야 합니다.", MINIMUM_NUMBER));
        Preconditions.checkMaximumNumber(number, MAXIMUM_NUMBER, String.format("%s 값 이하이어야 합니다.", MAXIMUM_NUMBER));

        this.number = number;
    }

    public static LottoNumber from(Integer number) {
        return new LottoNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
