package lotto.model;

import java.util.Arrays;

public enum PrizeType {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int matchNum;
    private int prizeMoney;

    PrizeType(int matchNum, int prizeMoney) {
        this.matchNum = matchNum;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchNum() {
        return matchNum;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getPrizeMoney(int num) {
        return prizeMoney * num;
    }

    /**
     * 매칭된 갯수와 보너스 볼 매칭여부에 따라 enum 가져오기
     *
     * @param matchNum
     * @param isMatchBonus
     * @return
     */
    public static PrizeType valueOf(int matchNum, boolean isMatchBonus) {
        if (isSecond(matchNum, isMatchBonus)) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(i -> !i.equals(SECOND))
                .filter(i -> i.getMatchNum() == matchNum)
                .findAny().orElse(MISS);
    }

    /**
     * 2등인지 여부
     *
     * @param matchNum
     * @param isMatchBonus
     * @return
     */
    private static boolean isSecond(int matchNum, boolean isMatchBonus) {
        if (matchNum == SECOND.matchNum && isMatchBonus) {
            return true;
        }

        return false;
    }


    /**
     * 당첨됐는지 여부
     *
     * @return
     */
    public boolean isWin() {
        return !this.equals(PrizeType.MISS);
    }
}
