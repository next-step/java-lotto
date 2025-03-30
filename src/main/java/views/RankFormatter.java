package views;

public class RankFormatter {

    private final int requiredMatches;
    private final long winnings;

    public RankFormatter(int requiredMatches, long winnings) {
        this.requiredMatches = requiredMatches;
        this.winnings = winnings;
    }

    public String format(String format) {
        return String.format(format, requiredMatches, winnings);
    }
}
