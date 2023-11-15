package lotto.domain;

public enum WinningEnum {
    FIRST(6,2000000000),
    THIRD(5,1500000);

    private int rank;
    private int winningAmount;

    WinningEnum(int rank, int winningAmount) {
        this.rank = rank;
        this.winningAmount = winningAmount;
    }
}
