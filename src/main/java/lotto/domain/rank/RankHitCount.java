package lotto.domain.rank;

public class RankHitCount {
    private final Rank rank;
    private int count;

    private RankHitCount(final Rank rank, final int count) {
        this.rank = rank;
        this.count = count;
    }

    public static RankHitCount of(final Rank rank, final int count) {
        return new RankHitCount(rank, count);
    }

    public static RankHitCount of(final Rank rank) {
        return of(rank, 0);
    }
    
    public void increase() {
        count += 1;
    }
    
    public boolean isMatch(final Rank rank) {
        return this.rank == rank;
    }
    
    public int getCount() {
        return count;
    }
}
