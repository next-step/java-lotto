package lotto;

import java.util.HashMap;
import java.util.Map;

import static lotto.LottoConfig.LOTTO_NUMBER_SIZE;

public enum LottoRank implements Comparable<LottoRank> {
    FOURTH(LOTTO_NUMBER_SIZE - 3, 5000),
    THIRD(LOTTO_NUMBER_SIZE - 2, 50000),
    SECOND(LOTTO_NUMBER_SIZE - 1, 1500000),
    FIRST(LOTTO_NUMBER_SIZE, 2000000000),
    ;

    private final Integer matchCount;
    private final Integer money;

    LottoRank(Integer matchCount, Integer money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    private static final Map<Integer, LottoRank> LOTTO_RANK = new HashMap<>();

    static {
        for (LottoRank lottoRank : LottoRank.values())
            LOTTO_RANK.put(lottoRank.matchCount, lottoRank);
    }

    public static LottoRank valueOfMatchCount(Integer matchCount) {
        return LOTTO_RANK.get(matchCount);
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getMoney() {
        return money;
    }


}
