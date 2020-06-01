package step2.model;

import step2.exception.NotEnoughMoneyException;

import java.text.MessageFormat;
import java.util.Objects;

public class Money {

    private static final int MIN_AMOUNT = 0;

    private final int totalAmount;
    private int usedAmount;

    private Money(int totalAmount) {
        if (totalAmount < MIN_AMOUNT) {
            throw new IllegalArgumentException("0원 이상 입력 할 수 있습니다.");
        }

        this.totalAmount = totalAmount;
    }

    public static Money valueOf(int totalAmount) {
        return new Money(totalAmount);
    }

    public void useAmount(Priceable priceable) {
        validateUseAmount(priceable);
        this.usedAmount += priceable.getPrice();
    }

    private void validateUseAmount(Priceable priceable) {
        if (priceable == null) {
            throw new IllegalArgumentException("금액을 입력해주세요.");
        }

        if (!this.isAvailableAmount(priceable)) {
            throw new NotEnoughMoneyException();
        }
    }

    public boolean isAvailableAmount(Priceable priceable) {
        return (this.usedAmount + priceable.getPrice()) <= this.totalAmount;
    }

    public int getBalance() {
        return this.totalAmount - this.usedAmount;
    }

    public int getUsedAmount() {
        return this.usedAmount;
    }

    public int getTotalAmount() {
        return this.totalAmount;
    }

    @Override
    public String toString() {
        return MessageFormat.format("총 금액:: {0}, 사용 금액:: {1}'}'", totalAmount, usedAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return getBalance() == money.getBalance();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getBalance());
    }
}
