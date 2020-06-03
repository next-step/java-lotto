package step2.model;

import step2.exception.NotEnoughMoneyException;

import java.text.MessageFormat;

public class MoneyAmount {

    private final Money totalAmount;
    private Money usedAmount;

    private MoneyAmount(Money money) {
        if (money == null) {
            throw new IllegalArgumentException();
        }

        this.totalAmount = money;
        this.usedAmount = Money.zero();
    }

    public static MoneyAmount create(Money money) {
        return new MoneyAmount(money);
    }

    public void useAmount(Priceable priceable) {
        if (priceable == null) {
            throw new IllegalArgumentException("금액을 입력해주세요.");
        }

        if (!isEnoughMoney(priceable)) {
            throw new NotEnoughMoneyException();
        }

        this.usedAmount = this.usedAmount.plus(priceable.getPrice());
    }

    public boolean isEnoughMoney(Priceable priceable) {
        Money availableAmount = totalAmount.minus(this.usedAmount);
        Money useAmount = priceable.getPrice();

        return availableAmount.greaterThan(useAmount);
    }

    public Money getTotalAmount() {
        return totalAmount;
    }

    public Money getUsedAmount() {
        return usedAmount;
    }

    @Override
    public String toString() {
        return MessageFormat.format("총 금액:: {0}, 남은 금액:: {1}", totalAmount, usedAmount);
    }


}
