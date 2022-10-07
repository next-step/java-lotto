package lotto.models;

import lotto.models.enums.Rank;

public class LottoStatistics {

    private Rank rank;
    private int count;

    private LottoStatistics(Rank rank) {
        this.rank = rank;
        this.count = 1;
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
