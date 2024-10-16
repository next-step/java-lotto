package lotto.entity;


import java.math.BigDecimal;

public class WinningResult {

    private final Rank rank;
    private int count;

    public WinningResult(Rank rank) {
        this(rank, 0);
    }

    public WinningResult(Rank rank, int count) {
        this.rank = rank;
        this.count = count;
    }

    public void increase() {
        this.count++;
    }

    public boolean isSame(Rank rank) {
        return this.rank == rank;
    }

    public BigDecimal add(BigDecimal sum) {
        return sum.add(calculateTotalAmount());
    }

    private BigDecimal calculateTotalAmount() {
        return BigDecimal.valueOf(this.count).multiply(this.rank.getPrizeMoney());
    }

    public int getCount() {
        return count;
    }

    public Rank getRank() {
        return rank;
    }
}
