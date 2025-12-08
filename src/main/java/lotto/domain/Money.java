package lotto.domain;

import java.util.Objects;

public class Money {
    private static final int MONEY_PER_LOTTO = 1_000;

    private final int money;

    public Money(int money) {
        this.money = money;
    }

    /**
     * 현재 금액으로 구매 가능한 최대 로또 티켓 개수를 반환합니다.
     */
    public int getLottoTicketCount() {
        return money / MONEY_PER_LOTTO;
    }

    /**
     * 지정된 개수만큼 로또를 구매하고 남은 금액을 가진 새로운 Money 객체를 반환합니다.
     */
    public Money subtractPurchaseAmount(int count) {
        return new Money(money - count * MONEY_PER_LOTTO);
    }

    /**
     * 다른 Money 객체의 금액을 현재 금액에 더한 새로운 Money 객체를 반환합니다.
     */
    public Money add(Money money) {
        return new Money(this.money + money.money);
    }


    public double calculateProfitRate(Money prize) {
        return (prize.money * 100) / money;
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
}
