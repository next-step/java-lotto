package study.lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum LottoRank {
    FIRST(2000000000, 6),
    SECOND(1500000, 5),
    THIRD(50000, 4),
    FOURTH(5000, 3);

    private static Map<Integer, LottoRank> map = new HashMap<>();

    private int prize;
    private int matchCount;

    LottoRank(int prize, int matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    static {
        for (LottoRank lottoRank : LottoRank.values()) {
            map.put(lottoRank.matchCount, lottoRank);
        }
    }

    public static LottoRank matchCountOf(Integer matchCount) {
        LottoRank lottoRank = map.get(matchCount);
        if (Objects.isNull(lottoRank)) {
            return null;
        }

        return lottoRank;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
