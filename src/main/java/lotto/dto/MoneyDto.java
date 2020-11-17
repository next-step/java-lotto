package lotto.dto;

import lotto.domain.Money;

public class MoneyDto {

    private final Money money;

    private MoneyDto(int money) {
        this.money = new Money(money);
    }

    public static MoneyDto of(int money) {
        return new MoneyDto(money);
    }

    public Money toEntity() {
        return money;
    }
}
