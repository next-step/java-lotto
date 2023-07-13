package lotto.model.domain;

import java.util.List;

public final class Ranks {

    private final List<Rank> ranks;

    private Ranks(final List<Rank> ranks) {
        this.ranks = ranks;
    }

    public static Ranks of(final List<Rank> ranks) {
        return new Ranks(ranks);
    }

    public int count(final Rank rank) {
        return -1;
    }
}
