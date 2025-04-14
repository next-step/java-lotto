package lotto.domain;

import java.util.HashMap;
import java.util.Map;

import static lotto.domain.BonusNumberMatchCondition.ANY;
import static lotto.domain.BonusNumberMatchCondition.MATCH;
import static lotto.domain.BonusNumberMatchCondition.NON_MATCH;
import static lotto.domain.LottoNumbers.LOTTO_SIZE;

public enum LottoRank {
    ETC(-1, ANY, 0),
    FIFTH(LOTTO_SIZE - 3, ANY, 5_000),
    FOURTH(LOTTO_SIZE - 2, ANY, 50_000),
    THIRD(LOTTO_SIZE - 1, NON_MATCH, 1_500_000),
    SECOND(LOTTO_SIZE - 1, MATCH, 30_000_000),
    FIRST(LOTTO_SIZE, NON_MATCH, 2_000_000_000),
    ;

    private final int matchCount;
    private final int money;
    private final BonusNumberMatchCondition bonusNumberMatchCondition;

    LottoRank(int matchCount, BonusNumberMatchCondition bonusNumberMatchCondition, int money) {
        this.matchCount = matchCount;
        this.bonusNumberMatchCondition = bonusNumberMatchCondition;
        this.money = money;
    }

    private static final Map<MatchResult, LottoRank> LOTTO_RANK = new HashMap<>();

    static {
        for (LottoRank lottoRank : LottoRank.values()) {
            putLottoRankMap(lottoRank);
        }
    }

    private static void putLottoRankMap(LottoRank lottoRank) {
        if (lottoRank.bonusNumberMatchCondition == MATCH || lottoRank.bonusNumberMatchCondition == ANY) {
            LOTTO_RANK.put(new MatchResult(lottoRank.matchCount, true), lottoRank);
        }

        if (lottoRank.bonusNumberMatchCondition == NON_MATCH || lottoRank.bonusNumberMatchCondition == ANY) {
            LOTTO_RANK.put(new MatchResult(lottoRank.matchCount, false), lottoRank);
        }
    }

    public static LottoRank valueOfMatchCount(MatchResult matchResult) {
        return LOTTO_RANK.getOrDefault(matchResult, ETC);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMoney() {
        return money;
    }

    public BonusNumberMatchCondition getBonusNumberMatchCondition() {
        return bonusNumberMatchCondition;
    }
}
