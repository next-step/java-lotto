package lotto.model.domain;

import java.util.ArrayList;
import java.util.List;

public final class RankResults {

    private final List<Rank> ranks;

    public RankResults(final List<Rank> ranks) {
        this.ranks = ranks;
    }

    public List<Rank> getRanks() {
        return new ArrayList<>(ranks);
    }
}
