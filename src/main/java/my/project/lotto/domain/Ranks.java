package my.project.lotto.domain;

import java.util.List;

public class Ranks {
    private final List<Rank> ranks;

    public Ranks(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public void add(Rank rank) {
        this.ranks.add(rank);
    }

}
