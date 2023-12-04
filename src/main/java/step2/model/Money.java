package step2.model;

import java.util.Objects;

public class Money {

    private static final int EACH_LOTTO_MONEY = 1000;
    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public Money purchaseManualLotto(int manualLottoCount) {
        validateExceededPurchaseAmount(manualLottoCount);
        return new Money(this.money - manualLottoCount * EACH_LOTTO_MONEY);
    }

    private void validateExceededPurchaseAmount(int manualLottoCount) {
        if (money < manualLottoCount * EACH_LOTTO_MONEY) {
            throw new IllegalArgumentException("제시한 금액보다 수동 로또 구매 금액이 더 큽니다.");
        }
    }

    public int determineLottoPurchaseCount() {
        return money / EACH_LOTTO_MONEY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
