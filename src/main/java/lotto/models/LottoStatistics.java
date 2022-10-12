package lotto.models;

import lotto.models.enums.Rank;

public class LottoStatistics {

    private final Rank rank;
    private int count;

    private LottoStatistics(Rank rank) {
        this.rank = rank;
        this.count = 0;
    }

    public Rank getRank() {
        return rank;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        this.count++;
    }

    public static LottoStatistics of(Rank rank) {
        return new LottoStatistics(rank);
    }
}
