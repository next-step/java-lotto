package lotto.domain;

public class GameResult {

    private final Rank rank;

    public GameResult(int matchCount, boolean matchBonus) {
        this.rank = Rank.valueOf(matchCount, matchBonus);
    }

    public Rank result() {
        return rank;
    }
}
