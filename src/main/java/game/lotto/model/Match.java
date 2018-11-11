package game.lotto.model;

public class Match {

    private int count;
    private Rank rank;

    public Match(Rank rank) {
        this.rank = rank;
    }

    public Match(Match match) {
        this.count = match.count;
        this.rank = match.rank;
    }

    public void plusCount() {
        this.count++;
    }

    public int getCount() {
        return this.count;
    }

    public Rank getRank() {
        return this.rank;
    }

    public long getTotalPrize() {
        return rank.getTotalPrize(this.count);
    }
}
