package lotto.entity;

import java.math.BigInteger;


public enum PrizeMoney {
    LOSE(0, null),
    THREE(3, BigInteger.valueOf(5000)),
    FOUR(4, BigInteger.valueOf(50000)),
    FIVE(5, BigInteger.valueOf(1500000)),
    SIX(6, BigInteger.valueOf(2000000000));

    private final int count;
    private final BigInteger prizeMoney;

    PrizeMoney(int count, BigInteger prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    public boolean isMatch(int count) {
        return this.count == count;
    }

    public boolean isWinner() {
        return this.prizeMoney != null;
    }
}
