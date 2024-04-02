package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum LottoRank {

    FIRST(LottoRankKey.of(6, false), 2_000_000_000),
    SECOND(LottoRankKey.of(5, true), 30_000_000),
    THIRD(LottoRankKey.of(5, false), 1_500_000),
    FOURTH(LottoRankKey.of(4, false), 50_000),
    FIFTH(LottoRankKey.of(3, false), 5_000),
    NONE(LottoRankKey.of(0, false), 0);

    private static final Map<LottoRankKey, LottoRank> cache = new HashMap<>();

    static {
        for(LottoRank lottoRank : LottoRank.values()) {
            cache.put(lottoRank.lottoRankKey, lottoRank);
        }
    }

    public static LottoRank of(int matchCount, boolean isBonus) {
        return cache.getOrDefault(LottoRankKey.of(matchCount, isBonus), NONE);
    }

    private final LottoRankKey lottoRankKey;
    private final int prizeMoney;


    LottoRank(LottoRankKey lottoRankKey, int prizeMoney) {
        this.lottoRankKey = lottoRankKey;
        this.prizeMoney = prizeMoney;
    }

    public int prizeMoney() {
        return prizeMoney;
    }

    public int matchCount() {
        return this.lottoRankKey.getMatchCount();
    }
}
