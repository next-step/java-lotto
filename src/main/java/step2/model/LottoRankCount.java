package step2.model;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoRankCount {

    private static final Integer MATCH_INITIAL_COUNT = 0;
    private static final Integer COUNT_OPERAND = 1;

    private final Map<LottoRank, Integer> lottoRankCount;

    private LottoRankCount() {
        lottoRankCount = Arrays.stream(LottoRank.values())
                .collect(Collectors.toMap(Function.identity(), v -> MATCH_INITIAL_COUNT));
    }

    public static LottoRankCount create() {
        return new LottoRankCount();
    }

    public void plusCount(LottoRank lottoRank) {
        this.lottoRankCount.computeIfPresent(lottoRank, (rank, count) -> count + COUNT_OPERAND);
    }

    public int findCount(LottoRank lottoRank) {
        return this.lottoRankCount.get(lottoRank);
    }
}
