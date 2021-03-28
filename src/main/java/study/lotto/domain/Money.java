package study.lotto.domain;

import study.lotto.exception.LottoException;

import java.math.BigDecimal;
import java.util.Objects;

import static study.lotto.util.Constants.*;

public class Money {

    private final BigDecimal money;

    private Money(final int money) {
        if(money < LOTTO_PRICE) {
            throw new LottoException(GUIDE_ERR_CANNOT_BUY_LOTTO);
        }
        this.money = new BigDecimal(money);
    }

    public static Money of(final int money) {
        return new Money(money);
    }

    public static Money of(final String money) {
        int parseMoney = parseIntMoney(money);
        return new Money(parseMoney);
    }

    private static int parseIntMoney(final String money) {
        try {
            return Integer.parseInt(money);
        } catch(NumberFormatException e) {
            throw new LottoException();
        }
    }

    public int autoSize(final int manualCount) {
        return money.divide(BigDecimal.valueOf(LOTTO_PRICE))
                .subtract(BigDecimal.valueOf(manualCount))
                .intValue();
    }

    public int totalSize() {
        return money.divide(BigDecimal.valueOf(LOTTO_PRICE))
                .intValue();
    }

    public void ensureBuyLotto(int manualCount) {
        int totalSize = money.divide(BigDecimal.valueOf(LOTTO_PRICE))
                .intValue();
        if(manualCount > totalSize) {
            throw new LottoException(GUIDE_ERR_GREATER_THAN_LOTTO_COUNT);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        final Money money1 = (Money) o;
        return Objects.equals(money, money1.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
