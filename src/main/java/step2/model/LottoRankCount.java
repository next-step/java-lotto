package step2.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoRankCount {

    private static final Integer MATCH_INITIAL_COUNT = 0;
    private static final Integer COUNT_OPERAND = 1;

    private final Map<LottoRank, Integer> lottoRankCount = new HashMap<>();

    private LottoRankCount() {
        Arrays.stream(LottoRank.values())
                .forEach(lottoRank -> this.lottoRankCount.put(lottoRank, MATCH_INITIAL_COUNT));
    }

    public static LottoRankCount create() {
        return new LottoRankCount();
    }

    public void plusCount(LottoRank lottoRank) {
        Integer matchCount = this.lottoRankCount.get(lottoRank);
        this.lottoRankCount.put(lottoRank, matchCount + COUNT_OPERAND);
    }

    public int findCount(LottoRank lottoRank) {
        return this.lottoRankCount.get(lottoRank);
    }
}
