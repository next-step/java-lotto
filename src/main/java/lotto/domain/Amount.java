package lotto.domain;

public enum Amount {

    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int count;
    private final int price;

    Amount(int count, int price) {
        this.count = count;
        this.price = price;
    }

    public static int getWinningMoney(int countWinnings) {
        MatchPrice matchPrice = new MatchPrice();

        for (Amount amount : values()) {
            matchPrice(amount, countWinnings, matchPrice);
        }

        return matchPrice.getMatchPrice();
    }

    public static void matchPrice(Amount amount, int countWinnings, MatchPrice matchPrice) {
        if (amount.count == countWinnings) {
            matchPrice.matching(amount.price);
        }
    }
}
