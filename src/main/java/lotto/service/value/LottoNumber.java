package lotto.service.value;

import lotto.utils.Preconditions;

import java.util.Objects;

import static lotto.rule.LottoRule.MAXIMUM_NUMBER;
import static lotto.rule.LottoRule.MINIMUM_NUMBER;

public class LottoNumber {
    private final Integer number;

    private LottoNumber(Integer number) {
        Preconditions.checkNotNull(number, "number는 필수값 입니다.");
        Preconditions.checkMinimumNumber(number, MINIMUM_NUMBER, String.format("%s 값 이상 이어야 합니다.", MINIMUM_NUMBER));
        Preconditions.checkMaximumNumber(number, MAXIMUM_NUMBER, String.format("%s 값 이하 이어야 합니다.", MAXIMUM_NUMBER));

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
