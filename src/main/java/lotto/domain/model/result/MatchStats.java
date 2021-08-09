package lotto.domain.model.result;

public class MatchStats {

    private final int countOfMatch;
    private final boolean matchBonus;

    private MatchStats(int countOfMatch, boolean matchBonus) {
        this.countOfMatch = countOfMatch;
        this.matchBonus = matchBonus;
    }

    public static MatchStats of(int countOfMatch, boolean matchBonus) {
        return new MatchStats(countOfMatch, matchBonus);
    }

    public boolean isLessThan(int countOfMatch) {
        return this.countOfMatch < countOfMatch;
    }

    public boolean countEquals(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

    public boolean isMatchBonus() {
        return this.matchBonus;
    }
}
