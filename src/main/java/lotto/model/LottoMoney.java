package lotto.model;

import java.util.Objects;

public class LottoMoney {

    private static final int LOTTO_UNIT = 1000;
    private static final int ZERO = 0;
    private final long money;

    public LottoMoney(final long money) {
        validateMoney(money);
        this.money = money;
    }

    public LottoMoney(final String money) {
        try {
            long num = Long.parseLong(money);
            validateMoney(num);
            this.money = num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 금액 범위가 Long 범위를 초과하였습니다");
        }
    }

    private void validateMoney(final long money) {
        if (money < ZERO) {
            throw new IllegalArgumentException("로또 머니가 양수여야 합니다.");
        }
        if (money % LOTTO_UNIT != 0) {
            throw new IllegalArgumentException("로또는 천원 단위입니다.");
        }
    }

    public long getLottoCount() {
        return money / LOTTO_UNIT;
    }

    public long getLottoMoney() {
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
