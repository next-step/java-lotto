package lotto;

import java.util.HashMap;
import java.util.Map;

import static lotto.LottoNumbers.LOTTO_SIZE;

public enum LottoRank {
    ETC(-1, 0),
    FOURTH(LOTTO_SIZE - 3, 5000),
    THIRD(LOTTO_SIZE - 2, 50000),
    SECOND(LOTTO_SIZE - 1, 1500000),
    FIRST(LOTTO_SIZE, 2000000000),
    ;

    private final int matchCount;
    private final int money;

    LottoRank(int matchCount, int money) {
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

    public int getMatchCount() {
        return matchCount;
    }

    public int getMoney() {
        return money;
    }
}
