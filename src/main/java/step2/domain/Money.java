package step2.domain;

import step2.exception.IsLessThanTheMiminumAmountOfMoneyException;

import java.util.Objects;

public class Money {

    private static final int MINIMUM_INPUT_MONEY = 1_000;
    public static final String MONEY_IS_LESS_THAN_1000 = "구입 금액은 최소 1000원이어야 합니다.";

    private final int money;

    public Money(int money) {
        if (money < MINIMUM_INPUT_MONEY) {
            throw new IsLessThanTheMiminumAmountOfMoneyException(MONEY_IS_LESS_THAN_1000);
        }
        this.money = money;
    }

    /**
     * 살 수 있는 복권 장 수를 얻는 메소드
     * @return 구입 가능한 복권 장 수
     */
    public int getNumberOfLottery() {
        return money / 1000;
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
