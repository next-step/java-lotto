package Lotto.domain;

import Lotto.exception.NotFoundRankException;

import java.util.stream.Stream;

public enum WinningRankInfo {

    FIRST(1, 2000000000, "6개 일치 (2000000000원)"),
    SECOND(2, 1500000, "5개 일치 (1500000원)"),
    THIRD(3, 50000, "4개 일치 (50000원)"),
    FOURTH(4, 5000, "3개 일치 (5000원)"),
    FIFTH(5, 0, ""),
    SIX(6, 0, ""),
    NONE(7, 0, "");

    private static final int VALID_RANK = 4;

    private final int rank;
    private final int winningMoney;
    private final String resultMessage;

    WinningRankInfo(int rank, int winningMoney, String resultMessage) {
        this.rank = rank;
        this.winningMoney = winningMoney;
        this.resultMessage = resultMessage;
    }

    public static WinningRankInfo findWinningRank(int Rank) {
        return Stream.of(values())
                .filter(rank -> (rank.rank == (Rank)))
                .findFirst()
                .orElseThrow(() -> new NotFoundRankException("등수를 찾을 수 없습니다."));
    }

    int sum(int winningMoneyNum) {
        return winningMoney * winningMoneyNum;
    }

    public String getRankMessage() {
        return resultMessage;
    }

    public boolean isValidRank() {
        return rank <= VALID_RANK;
    }

}
