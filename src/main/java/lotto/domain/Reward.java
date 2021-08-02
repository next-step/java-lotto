package lotto.domain;

public enum Reward {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private int rightNumberCount;
    private int money;

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
