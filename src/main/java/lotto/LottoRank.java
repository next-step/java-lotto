package lotto;

import java.util.HashMap;
import java.util.Map;

public enum LottoRank {
    ETC(-1, 0),
    FOURTH(LottoNumbersCondition.getDefaultInstance().getLottoNumberSize() - 3, 5000),
    THIRD(LottoNumbersCondition.getDefaultInstance().getLottoNumberSize() - 2, 50000),
    SECOND(LottoNumbersCondition.getDefaultInstance().getLottoNumberSize() - 1, 1500000),
    FIRST(LottoNumbersCondition.getDefaultInstance().getLottoNumberSize(), 2000000000),
    ;

    private final Integer matchCount;
    private final Integer money;

    LottoRank(Integer matchCount, Integer money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    private static final Map<Integer, LottoRank> LOTTO_RANK = new HashMap<>();

    static {
        for (LottoRank lottoRank : LottoRank.values()) {
            LOTTO_RANK.put(lottoRank.matchCount, lottoRank);
        }
    }

    public static LottoRank valueOfMatchCount(Integer matchCount) {
        return LOTTO_RANK.getOrDefault(matchCount, ETC);
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getMoney() {
        return money;
    }
}
