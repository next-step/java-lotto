package my.project.lotto.dto;

import my.project.lotto.domain.Rank;

import java.util.List;

public class Ranks {
    private final List<Rank> ranks;

    public Ranks(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public void add(Rank rank) {
        this.ranks.add(rank);
    }

    public List<Rank> getRanks() {
        return ranks;
    }

    public int size() {
        return ranks.size();
    }
}
