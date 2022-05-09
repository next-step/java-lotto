package Lotto.domain;

import Lotto.exception.NotFoundRankException;

import java.util.stream.Stream;

public enum EqualLottoCntInfo {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    FIFTH(2, 0),
    SIX(1, 0),
    NONE(0, 0);

    private static final int MIN_COUNT = 3;

    private final int equalCnt;
    private final int winningMoney;

    EqualLottoCntInfo(int equalCnt, int winningMoney) {
        this.equalCnt = equalCnt;
        this.winningMoney = winningMoney;
    }

    public static EqualLottoCntInfo findEqualLottoInfo(int equalCnt) {
        return Stream.of(values())
                .filter(WinningRankInfo -> (WinningRankInfo.equalCnt == (equalCnt)))
                .findFirst()
                .orElseThrow(() -> new NotFoundRankException("등수를 찾을 수 없습니다."));
    }

    public int calcTotalWinningMoney(int winningNumberCount) {
        return winningMoney * winningNumberCount;
    }

    public int getEqualCnt() {
        return equalCnt;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean isValidEqualCnt() {
        return equalCnt >= MIN_COUNT;
    }
}
