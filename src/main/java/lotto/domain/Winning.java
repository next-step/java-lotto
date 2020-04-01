package lotto.domain;

public enum Winning {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 1500000),
    THIRD_PLACE(4, 50000),
    FOURTH_PLACE(3, 5000),
    LOSE(0, 0);

    int matchCount;
    int winningPrice;

    Winning(int matcheCount, int winningPrice) {
        this.matchCount = matcheCount;
        this.winningPrice = winningPrice;
    }
}
