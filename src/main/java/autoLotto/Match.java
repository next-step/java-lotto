package autoLotto;

public enum Match {
    THREE(5000L, 0),
    FOUR(50000L, 0),
    FIVE(1500000L, 0),
    SIX(2000000000L, 0);

    private Long winningAmount;
    private int countOfMatch;

    Match(final Long winningAmount, final int countOfMatch) {
        this.winningAmount = winningAmount;
        this.countOfMatch = countOfMatch;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public void countOfMatch() {
        this.countOfMatch++;
    }

    public Long getTotalAmount() {
        return this.countOfMatch * this.winningAmount;
    }
}
