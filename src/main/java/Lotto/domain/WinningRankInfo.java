package Lotto.domain;

import Lotto.exception.NotFoundRankException;

import java.util.stream.Stream;

public enum WinningRankInfo {

    FIRST(1, 2000000000),
    SECOND(2, 1500000),
    THIRD(3, 50000),
    FOURTH(4, 5000),
    FIFTH(5, 0),
    SIX(6, 0),
    NONE(7, 0);

    private static final int VALID_RANK = 4;

    private final int rank;
    private final int winningMoney;

    WinningRankInfo(int rank, int winningMoney) {
        this.rank = rank;
        this.winningMoney = winningMoney;
    }

    public static WinningRankInfo findWinningRank(int Rank) {
        return Stream.of(values())
                .filter(WinningRankInfo -> (WinningRankInfo.rank == (Rank)))
                .findFirst()
                .orElseThrow(() -> new NotFoundRankException("등수를 찾을 수 없습니다."));
    }

    public int calcTotalWinningMoney(int winningNumberCount) {
        return winningMoney * winningNumberCount;
    }

    public boolean isValidRank() {
        return rank <= VALID_RANK;
    }
}
