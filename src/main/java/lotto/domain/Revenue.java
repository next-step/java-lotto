package lotto.domain;

import java.util.Arrays;

public enum Revenue {
    THREE(5000, 3, false),
    FOUR(50000, 4, false),
    FIVE(1500000, 5, false),
    FIVE_AND_BONUS(30000000, 5, true),
    SIX(2000000000, 6, false),
    NOTHING(0, 0, false);

    private final long revenue;
    private final int matchNum;
    private final Boolean bonus;
    private static Revenue matchedRevenue;

    Revenue(long revenue, int matchNum, Boolean bonus) {
        this.revenue = revenue;
        this.matchNum = matchNum;
        this.bonus = bonus;
    }

    public long getRevenue() {
        return revenue;
    }

    public boolean getBonus() {
        return bonus;
    }

    public int getMatchNum() {
        return matchNum;
    }

    public int totalRevenue(int lottoCount) {
        return (int) revenue * lottoCount;
    }

    public static Revenue checkTheNumberOfMatchingLotto(Ticket ticket, WinningInfo winningInfo) {
        matchedRevenue = Arrays.stream(Revenue.values())
            .filter(
                revenue -> revenue.matchNum == winningInfo.matchWinning(ticket)
            )
            .findFirst().orElse(NOTHING);

        return matchedRevenue.isFiveAndBonusMatch(ticket, winningInfo);
    }

    private Revenue isFiveAndBonusMatch(Ticket ticket, WinningInfo winningInfo) {
        if (matchedRevenue == Revenue.FIVE && winningInfo.matchBonus(ticket)) {
            return Revenue.FIVE_AND_BONUS;
        }
        return matchedRevenue;
    }


}
