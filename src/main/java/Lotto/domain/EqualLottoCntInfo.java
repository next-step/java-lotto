package Lotto.domain;

import Lotto.exception.NotFoundRankException;

import java.util.stream.Stream;

public enum EqualLottoCntInfo {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    BONUS(5, 30000000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    FIFTH(2, 0),
    SIX(1, 0),
    NONE(0, 0);

    private static final int MIN_COUNT = 3;
    private static final int BONUS_EQUAL_COUNT = 5;

    private final int equalCnt;
    private final Money winningMoney;

    EqualLottoCntInfo(int equalCnt, int winningMoney) {
        this.equalCnt = equalCnt;
        this.winningMoney = Money.createWinningMoney(winningMoney);
    }

    public static EqualLottoCntInfo findEqualLottoInfo(int equalCnt, boolean isBonus) {
        if (isNotBonusRank(equalCnt, isBonus)) {
            return Stream.of(values())
                    .filter(EqualLottoCntInfo -> (EqualLottoCntInfo.equalCnt == (equalCnt)))
                    .findFirst()
                    .orElseThrow(() -> new NotFoundRankException("등수를 찾을 수 없습니다."));
        }
        return EqualLottoCntInfo.BONUS;
    }

    private static boolean isNotBonusRank(int equalCnt, boolean isBonus) {
        return equalCnt != BONUS_EQUAL_COUNT || !isBonus;
    }

    public int calcTotalWinningMoney(int winningNumberCount) {
        return winningMoney.getMoney() * winningNumberCount;
    }

    public boolean isWinningBonus() {
        return ((this == EqualLottoCntInfo.BONUS) && (equalCnt == 5));
    }

    public int getEqualCnt() {
        return equalCnt;
    }

    public int getWinningMoney() {
        return winningMoney.getMoney();
    }

    public boolean isWinning() {
        return equalCnt >= MIN_COUNT;
    }
}
