package lotto.domain;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private int winningCount, money;

    Rank(int winningCount, int money) {
        this.winningCount = winningCount;
        this.money = money;
    }
}
