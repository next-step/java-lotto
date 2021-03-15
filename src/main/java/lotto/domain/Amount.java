package lotto.domain;

public enum Amount {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int count;
    private final int amount;

    Amount(int count, int amount) {
        this.count = count;
        this.amount = amount;
    }

    public static int getWinningMoney(int countWinnings) {
        Amount[] amounts = values();
        for (Amount amount : amounts) {
            if (amount.count == countWinnings) {
                return amount.amount;
            }
        }

        return 0;
    }
}
