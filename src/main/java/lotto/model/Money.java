package lotto.model;

import java.util.Objects;

public class Money {
    private static final Long MONEY_TO_BUY_ONE_LOTTO = 1000L;
    private static final Long ZERO_MONEY = 0L;

    private Long money;

    public Money (){
        this.money = 0l;
    }

    public Money(Long money) {
        validateNegative(money);
        this.money = money;
    }

    private void validateNegative(Long money) {
        if (isNegative(money)) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    private boolean isNegative(Long money) {
        return money < ZERO_MONEY;
    }

    public int findLottoCountToBuy() {
        return (int) Math.floor(this.money / MONEY_TO_BUY_ONE_LOTTO) ;
    }

    public Money add(Money money){
        return new Money(this.money + money.getMoney());
    }

    public Long getMoney() {
        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return Objects.equals(money, money1.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}