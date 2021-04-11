package step02;

import java.util.ArrayList;
import java.util.List;

public class Ranks {

    private List<Rank> ranks = new ArrayList<>();

    public void setRanks(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public void addRanks(Rank rank) {
        ranks.add(rank);
    }

    public int getNumberOfEachRank(Rank rank) {
        return ranks.stream()
                .filter(rankCount -> rankCount == rank)
                .toArray().length;
    }
}
