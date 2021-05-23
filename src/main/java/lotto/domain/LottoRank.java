package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum LottoRank {
    FIRST("1", 6, 2000000000),
    SECOND("2", 5, 30000000),
    THIRD("3", 5, 1500000),
    FOURTH("4", 4, 50000),
    FIFTH("5", 3, 5000),
    MISS("0", 2, 0);

    private final String rank;
    private final int matchCount;
    private final int profit;

    LottoRank(String grade, int matchCount, int profit) {
        this.rank = grade;
        this.matchCount = matchCount;
        this.profit = profit;
    }

    public int matchCount() {
        return matchCount;
    }

    public int profit() {
        return profit;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 5) {
            return MAP_LOTTO_RANK.get(matchCount + Boolean.hashCode(matchBonus));
        }
        return MAP_LOTTO_RANK.get(matchCount + Boolean.hashCode(false));
    }

    public static final Map<Integer, LottoRank> MAP_LOTTO_RANK;
    static {
        Map<Integer, LottoRank> mapLottoRank = new HashMap<>();
        mapLottoRank.put(0 + Boolean.hashCode(false), LottoRank.MISS);
        mapLottoRank.put(1 + Boolean.hashCode(false), LottoRank.MISS);
        mapLottoRank.put(2 + Boolean.hashCode(false), LottoRank.MISS);
        mapLottoRank.put(3 + Boolean.hashCode(false), LottoRank.FIFTH);
        mapLottoRank.put(4 + Boolean.hashCode(false), LottoRank.FOURTH);
        mapLottoRank.put(5 + Boolean.hashCode(false), LottoRank.THIRD);
        mapLottoRank.put(5 + Boolean.hashCode(true), LottoRank.SECOND);
        mapLottoRank.put(6 + Boolean.hashCode(false), LottoRank.FIRST);

        MAP_LOTTO_RANK = Collections.unmodifiableMap(mapLottoRank);
    }
}
