package step4.VO;

import java.util.Objects;

public class Money {
    public static final int lottoPrice = 1000;
    private final int money;

    public Money(int inputNumber) {
        validate(inputNumber);
        this.money = inputNumber;
    }

    private void validate(int inputNumber) {
        if (inputNumber < lottoPrice) {
            throw new IllegalArgumentException("이 금액으로는 로또를 살 수 없습니다.");
        }
    }

    public int getLottoCnt() {
        return money / lottoPrice;
    }

    public float getMarginByMoney(float totalReward) {
        return totalReward / money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money that = (Money) o;
        return money == that.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    @Override
    public String toString() {
        return Integer.toString(money);
    }
}
