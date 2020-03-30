package study.lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum LottoRank {
    FIRST(2_000_000_000, 6),
    SECOND(1_500_000, 5),
    THIRD(50_000, 4),
    FOURTH(5_000, 3);

    private static Map<Integer, LottoRank> matchCountToLottoRank =
            new HashMap<>();

    private int prize;
    private int matchCount;

    LottoRank(int prize, int matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    static {
        for (LottoRank lottoRank : LottoRank.values()) {
            matchCountToLottoRank.put(lottoRank.matchCount, lottoRank);
        }
    }

    public static LottoRank matchCountOf(Integer matchCount) {
        return matchCountToLottoRank.get(matchCount);
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
