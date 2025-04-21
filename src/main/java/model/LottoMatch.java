package model;

public class LottoMatch {
    private final int countOfMatch;
    private final boolean matchBonus;

    public LottoMatch(int countOfMatch, boolean matchBonus) {
        this.countOfMatch = countOfMatch;
        this.matchBonus = matchBonus;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public boolean doesCountMatch(int number) {
        return countOfMatch == number;
    }
}
