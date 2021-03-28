package step2.domain;

import java.util.List;
import java.util.Map;

public class Candidate {

    private final Map<Rank, List<Game>> rank;

    public Candidate(Map<Rank, List<Game>> rank) {
        this.rank = rank;
    }

    public Map<Rank, List<Game>> rank() {
        return this.rank;
    }

    public Integer count(Rank prizeRank) {
        if (rank.get(prizeRank) == null) {
            return 0;
        }
        return rank.get(prizeRank).size();
    }
}
