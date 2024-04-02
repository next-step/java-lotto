package lottery.domain;

import java.util.Objects;

public class Money {
    private Integer amount;

    public Money(Integer amount) {
        validateMoney(amount);
        this.amount = amount;
    }

    public Integer amount(){
        return this.amount;
    }

    public void decrease(Integer amount){
        if (amount > this.amount)
            throw new IllegalArgumentException("금액이 부족합니다.");
        this.amount = this.amount - amount;
    }

    public Boolean isZero(){
        return this.amount.equals(0);
    }

    private static void validateMoney(Integer amount){
        if (Objects.isNull(amount))
            throw new IllegalArgumentException("구입 금액은 필수 입니다.");
        if (amount % LottoTicket.PRICE != 0)
            throw new IllegalArgumentException("구입 금액은 1000 단위 입니다.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }


}
