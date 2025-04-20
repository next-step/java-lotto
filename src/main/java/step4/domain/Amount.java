package step4.domain;

import java.math.BigInteger;
import java.util.Objects;

/**
 * 가격을 나타내는 VO
 */
public class Amount {
    private final BigInteger amount;

    /**
     * generator
     */
    private Amount(BigInteger amount) {
        if (amount.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("금액은 0보다 커야 합니다.");
        }
        this.amount = amount;
    }

    public Amount(int amount) {
        this(BigInteger.valueOf(amount));
    }

    /**
     * VO 계산 메서드
     */
    public Amount add(Amount amount) {
        return new Amount(this.amount.add(amount.getAmount()));
    }

    public Amount multiplyByCount(int count) {
        return new Amount(this.amount.multiply(BigInteger.valueOf(count)));
    }

    public int divideIntoCount(Amount amount) {
        return this.amount.divide(amount.amount).intValue();
    }

    public BigInteger getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Amount amount1 = (Amount)o;
        return Objects.equals(amount, amount1.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(amount);
    }
}
