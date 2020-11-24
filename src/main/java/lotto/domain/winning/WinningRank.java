package lotto.domain.winning;

import java.util.Arrays;

/**
 * Created By mand2 on 2020-11-20.
 */
public enum WinningRank {

    FIRST(6, 2_000_000_000, 1),
    THIRD(5, 1_500_000, 3),
    FOURTH(4, 50_000, 4),
    FIFTH(3, 5_000, 5),
    NONE(0, 0, 6);

    private int winningResult;
    private int prize;
    private int rank;

    WinningRank(int winningResult, int prize, int rank) {
        this.winningResult = winningResult;
        this.prize = prize;
        this.rank = rank;
    }

    public static WinningRank getWinningRank(int winningResult) {
        return Arrays.stream(values())
                .filter(rank -> rank.winningResult == winningResult)
                .findFirst()
                .orElse(NONE);
    }

    public int getWinningResult() {
        return winningResult;
    }

    public int getPrize() {
        return prize;
    }

    public int getRank() {
        return rank;
    }
}
