package step2.domain.winning;

public enum WinningAmount {
    FIRST(2000000000),
    SECOND(1500000),
    THIRD(50000),
    FORTH(5000);

    private final int amount;

    WinningAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
