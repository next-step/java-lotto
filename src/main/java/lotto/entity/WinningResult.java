package lotto.entity;


import java.math.BigDecimal;

public class WinningResult {

    private final PrizeMoney prizeMoney;
    private int count;

    public WinningResult(PrizeMoney prizeMoney) {
        this(prizeMoney, 0);
    }

    public WinningResult(PrizeMoney prizeMoney, int count) {
        this.prizeMoney = prizeMoney;
        this.count = count;
    }

    public void increase() {
        this.count++;
    }

    public boolean isSame(PrizeMoney prizeMoney) {
        return this.prizeMoney == prizeMoney;
    }

    public BigDecimal add(BigDecimal sum) {
        return sum.add(calculateTotalAmount());
    }

    private BigDecimal calculateTotalAmount() {
        return BigDecimal.valueOf(this.count).multiply(this.prizeMoney.getPrizeMoney());
    }

    public int getCount() {
        return count;
    }

    public PrizeMoney getPrizeMoney() {
        return prizeMoney;
    }
}
