package step4.lotto.domain;

import java.util.Objects;

public class Money {
    private static final int LOTTO_PRIZE = 1_000;
    private final int money;

    public Money() {
        this.money = 0;
    }

    public Money(int money) {
        this.money = money;
    }

    public int lottoCount(){
        return money/LOTTO_PRIZE;
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

    public int divide(int lottoPrize) {
        return this.money / lottoPrize;
    }

    public String profits(int prize) {
        return String.format("총 수익률은 %.2f입니다.(기준이 1이기 떄문에 결과적으로 손해라는 의미임)", (double) prize/money);

    }
}
