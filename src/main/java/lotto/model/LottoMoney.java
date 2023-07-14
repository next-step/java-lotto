package lotto.model;

import java.util.Objects;

public class LottoMoney {

    private static final int LOTTO_PRICE = 1_000;

    private final int value;

    public LottoMoney(final int value) {
        validateValue(value);
        this.value = value;
    }

    private static void validateValue(int value) {
        if (value < LOTTO_PRICE) {
            throw new IllegalArgumentException(
                    "로또를 구입하기에 돈이 부족합니다. 로또는 한 장에 " + LOTTO_PRICE + "원이고, 현재 구입 금액은 "
                            + value + "원 입니다.");
        }
    }

    public int getChange() {
        return value % LOTTO_PRICE;
    }

    public int getTotalCount() {
        return value / LOTTO_PRICE;
    }

    public double getTotalSpentMoney() {
        return (double) value - getChange();
    }

    int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoMoney that = (LottoMoney) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
