package lotto.domain.money;

import lotto.domain.lotto.count.Count;
import lotto.util.MoneyValidator;

public class Money {

    private static final int LOTTO_MONEY = 1000;

    private final int value;

    public Money(String input) {
        this(MoneyValidator.parseToInt(input));
    }

    public Money(int value) {
        this.value = MoneyValidator.validate(value);
    }

    public int getValue() {
        return value;
    }

    public Count calculateLottoCount() {
        return new Count(value / LOTTO_MONEY);
    }
}
