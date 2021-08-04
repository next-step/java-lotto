package lotto.domain;

public enum Reward {

    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int rightNumberCount;
    private final int money;

    public int getRightNumberCount() {
        return rightNumberCount;
    }

    public int getMoney() {
        return money;
    }

    Reward(int rightNumberCount, int money) {
        this.rightNumberCount = rightNumberCount;
        this.money = money;
    }
}
