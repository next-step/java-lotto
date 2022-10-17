package lotto.model;

import java.util.Objects;

public class BonusNumber {
    private final Integer number;

    private BonusNumber(Integer number) {
        this.number = number;
    }

    public static BonusNumber of(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("1이상 45이하의 숫자만 가능합니다");
        }

        return new BonusNumber(number);
    }

    public boolean match(Integer number) {
        return Objects.equals(this.number, number);
    }
}
