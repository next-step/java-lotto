package lotto.domain;

import java.util.InputMismatchException;
import java.util.Objects;

public class Money {
    public static final int THOUSAND_UNITS = 1000;


    private final long money;

    public Money(long money) {
        this.money = validate(money);
    }

    private long validate(long money) {
        if (isNotMatchUnits(money)) {
            throw new InputMismatchException("금액은 천단위만 입력이 가능합니다.");
        }
        return money;
    }

    private boolean isNotMatchUnits(long money) {
        return money % THOUSAND_UNITS != 0;
    }


    public Money plus(long addMoney) {
        return new Money(this.money + addMoney);
    }

    public long find() {
        return this.money;
    }

    public int calculateUnits() {
        return (int) this.money / THOUSAND_UNITS;
    }

    public float rateOfReturn(Money seed) {
        return (float) this.money / seed.find();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    @Override
    public String toString() {
        return String.valueOf(money);
    }
}
