package study.lotto.domain;

import java.util.*;

public enum LottoRank {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    MISS(0, 0, false);

    private static Map<Integer, List<LottoRank>> valueToLottoRank =
            new HashMap<>();

    private long prize;
    private int matchCount;
    private boolean matchBonus;

    LottoRank(long prize, int matchCount, boolean matchBonus) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    static {
        initValueToLottoRank();
        for (LottoRank lottoRank : LottoRank.values()) {
            valueToLottoRank.get(lottoRank.matchCount).add(lottoRank);
        }
    }

    private static void initValueToLottoRank() {
        for (LottoRank lottoRank : LottoRank.values()) {
            valueToLottoRank.put(lottoRank.getMatchCount(), new ArrayList<>());
        }
    }

    public static LottoRank valueOf(Integer matchCount, boolean matchBonus) {
        List<LottoRank> lottoRanks = valueToLottoRank.get(matchCount);
        if (Objects.isNull(lottoRanks)) {
            return MISS;
        }

        return lottoRanks.stream()
                .filter(v -> v != LottoRank.SECOND || v.matchBonus == matchBonus)
                .findFirst()
                .orElse(MISS);
    }

    public long getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }
}
