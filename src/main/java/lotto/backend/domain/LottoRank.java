package lotto.backend.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NOTHING(0, 0);

    private static final Map<Integer, LottoRank> CACHED_LOTTO_RANK = new HashMap<>();

    static {
        for (LottoRank rank : LottoRank.values()) {
            CACHED_LOTTO_RANK.put(rank.match, rank);
        }
    }

    private final int match;
    private final int prize;

    LottoRank(int match, int prize) {
        this.match = match;
        this.prize = prize;
    }

    public static LottoRank of(int match) {
        if (CACHED_LOTTO_RANK.containsKey(match)) {
            return CACHED_LOTTO_RANK.get(match);
        }
        return CACHED_LOTTO_RANK.get(0);
    }

    public int getPrize() {
        return this.prize;
    }
}
