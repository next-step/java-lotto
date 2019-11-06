package lotto.domain;

import lotto.Rank;

import java.util.List;

public class Ranks {

    private List<Rank> ranks;

    public Ranks(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public List<Rank> getRanks() {
        return ranks;
    }
}
