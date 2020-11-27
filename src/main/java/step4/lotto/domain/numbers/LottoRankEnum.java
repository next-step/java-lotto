package step4.lotto.domain.numbers;

import step4.lotto.util.LottoErrorMessage;

import java.util.HashMap;
import java.util.Map;

public enum LottoRankEnum {

    LOTTO_MATCH_COUNT_3(3, 5), // 5000
    LOTTO_MATCH_COUNT_4(4, 4), // 5000
    LOTTO_MATCH_COUNT_5(5, 3), // 100000
    LOTTO_MATCH_COUNT_6(6, 2), // 3억
    LOTTO_MATCH_COUNT_7(7, 1); // 20억

    private int lottoMatchCount = 0;
    private int lottoRank = 0;

    LottoRankEnum(int lottoMatchCount, int lottoRank) {
        this.lottoMatchCount = lottoMatchCount;
        this.lottoRank = lottoRank;
    }

    private static final Map<Integer, LottoRankEnum> matchCountMap = new HashMap<>();

    static {
        for (LottoRankEnum matchCount : LottoRankEnum.values()) {
            matchCountMap.put(matchCount.getLottoMatchCount(), matchCount);
        }
    }

    public static LottoRankEnum findByRank(int matchCount) {
        if (!matchCountMap.containsKey(matchCount)) {
            throw new RuntimeException(LottoErrorMessage.getLottoRankException());
        }

        return matchCountMap.get(matchCount);
    }

    public int getLottoMatchCount() {
        return lottoMatchCount;
    }

    public int getLottoRank() {
        return lottoRank;
    }
}
