package lotto.model;

import java.util.Objects;

public class LottoMoney {

    private static final int LOTTO_UNIT = 1000;
    private static final int ZERO = 0;
    private final int money;

    public LottoMoney(final int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(final int money) {
        if (money < ZERO) {
            throw new IllegalArgumentException("로또 머니가 양수여야 합니다.");
        }
        if (money % LOTTO_UNIT != 0) {
            throw new IllegalArgumentException("로또는 천원 단위입니다.");
        }
    }

    public int getLottoCount() {
        return money / LOTTO_UNIT;
    }

    public int getLottoMoney() {
        return money;
    }

    public LottoMoney subtractByLottoCount(final Count count) {
        return new LottoMoney(money - count.getCount() * LOTTO_UNIT);
    }

    public boolean isPositive() {
        return this.money > ZERO;
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
        return money == that.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    @Override
    public String toString() {
        return "LottoMoney{" +
            "money=" + money +
            '}';
    }

}
