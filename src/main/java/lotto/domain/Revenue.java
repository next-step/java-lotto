package lotto.domain;

import java.util.Arrays;

public enum Revenue {

    THREE_MATCHES(5000, 3, false),
    FOUR_MATCHES(50000, 4, false),
    FIVE_MATCHES(1500000, 5, false),
    FIVE_AND_BONUS_MATCHES(30000000, 5, true),
    SIX_MATCHES(2000000000, 6, false),
    NOTHING(0, 0, false);

    private final long revenue;
    private final int matchNum;
    private final Boolean bonus;

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

    public static Revenue checkTheNumberOfMatchingLotto(Ticket ticket,
        WinningNumber winningNumber) {
        long matchingCount = winningNumber.checkTicketAndWinning(ticket);
        boolean isMatchingWithBonus = winningNumber.checkTicketAndBonus(ticket);
        return Arrays.stream(Revenue.values())
            .filter(revenue -> revenue.matchNum == matchingCount)
            .filter(revenue -> revenue.bonus == isMatchingWithBonus)
            .findFirst().orElse(NOTHING);
    }


}
