package views;

import step2.domain.rank.RankType;

public class RankFormatter {

    private final int requiredMatches;
    private final long winnings;

    private RankFormatter(int requiredMatches, long winnings) {
        this.requiredMatches = requiredMatches;
        this.winnings = winnings;
    }

    public RankFormatter(RankType rank) {
        this(rank.getRequiredMatches(), rank.getWinnings());
    }

    public String format(String format) {
        return String.format(format, requiredMatches, winnings);
    }
}
