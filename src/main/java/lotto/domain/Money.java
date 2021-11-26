package lotto.domain;

import lotto.exception.ManualLottoCountException;

public class Money {
    public static final int LOTTO_PRICE = 1000;
    public static final int ZERO = 0;

    private int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money from(int money) {
        return new Money(money);
    }

    public int lottoCount() {
        return money / LOTTO_PRICE;
    }

    public int validateManualLottoCount(int manualLottoCount) {
        if (manualLottoCount * LOTTO_PRICE > money) {
            throw new ManualLottoCountException(manualLottoCount);
        }
        return manualLottoCount;
    }

    public Money manualLottoMoney(int manualLottoCount) {
        validateManualLottoCount(manualLottoCount);
        return new Money(manualLottoCount * LOTTO_PRICE);
    }

    public Money autoLottoMoney(int manualLottoCount) {
        return new Money(money - (manualLottoCount * LOTTO_PRICE));
    }

    public boolean canBuy() {
        return money >= LOTTO_PRICE;
    }

    public void buy() {
        this.money -= LOTTO_PRICE;
    }
}
