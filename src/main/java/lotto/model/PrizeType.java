package lotto.model;

import java.util.Arrays;

public enum PrizeType {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private Integer matchNum;
    private Integer prizeMoney;

    PrizeType(Integer matchNum, Integer prizeMoney) {
        this.matchNum = matchNum;
        this.prizeMoney = prizeMoney;
    }

    public Integer getMatchNum() {
        return matchNum;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }

    /**
     * 매칭된 갯수와 보너스 볼 매칭여부에 따라 enum 가져오기
     *
     * @param matchNum
     * @param isMatchBonus
     * @return
     */
    public static PrizeType valueOf(int matchNum, boolean isMatchBonus) {
        PrizeType[] types = values();
        PrizeType secondOrThird = getSecondOrThird(matchNum, isMatchBonus);
        if (secondOrThird != null) {
            return secondOrThird;
        }

        return Arrays.stream(types)
                .filter(i -> i.getMatchNum() == matchNum)
                .findAny().orElse(MISS);
    }

    /**
     * 2등 혹은 3등 가져오기
     *
     * @param matchNum
     * @param isMatchBonus
     * @return
     */
    private static PrizeType getSecondOrThird(int matchNum, boolean isMatchBonus) {
        if (matchNum == SECOND.matchNum && isMatchBonus) {
            return SECOND;
        } else if (matchNum == THIRD.matchNum && !isMatchBonus) {
            return THIRD;
        }

        return null;
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
