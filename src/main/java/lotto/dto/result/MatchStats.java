package lotto.dto.result;

import lotto.constant.Rank;

public class MatchStats {

    private int count;
    private Rank rank;

    public MatchStats(int count, Rank rank) {
        this.count = count;
        this.rank = rank;
    }

    public int count() {
        return count;
    }

    public Rank matchResult() {
        return rank;
    }
}
