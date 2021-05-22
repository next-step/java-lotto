package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum LottoRank {
    FIRST("1", 6, 2000000000),
    SECOND("2", 5, 30000000),
    THIRD("3", 5, 150000),
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
        // TODO 일치하는 수를 로또 등수로 변경한다. enum 값 목록은 "Rank[] ranks = values();"와 같이 가져올 수 있다.
        if (matchCount == 5 && matchBonus) {
            return LottoRank.SECOND;
        }
        if (matchCount == 5) {
            return LottoRank.THIRD;
        }
        if (matchCount > 2) {
            return MAP_LOTTO_RESULT.get(matchCount);
        }
        return MAP_LOTTO_RESULT.get(0);
    }

    public static final Map<Integer, LottoRank> MAP_LOTTO_RESULT;
    static {
        Map<Integer, LottoRank> mapLottoResult = new HashMap<>();
        mapLottoResult.put(0, LottoRank.MISS);
        mapLottoResult.put(1, LottoRank.MISS);
        mapLottoResult.put(2, LottoRank.MISS);
        mapLottoResult.put(3, LottoRank.FIFTH);
        mapLottoResult.put(4, LottoRank.FOURTH);
        mapLottoResult.put(5, LottoRank.THIRD);

        mapLottoResult.put(6, LottoRank.FIRST);
        MAP_LOTTO_RESULT = Collections.unmodifiableMap(mapLottoResult);
    }
}
