package step2.model;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MatchResult {

    private static final Integer MATCH_INITIAL_COUNT = 0;
    private static final Integer COUNT_OPERAND = 1;

    private final Map<LottoRank, Integer> matchResult;

    private MatchResult() {
        matchResult = Arrays.stream(LottoRank.values())
                .collect(Collectors.toMap(Function.identity(), v -> MATCH_INITIAL_COUNT));
    }

    public static MatchResult create() {
        return new MatchResult();
    }

    public void plusCount(LottoRank lottoRank) {
        this.matchResult.computeIfPresent(lottoRank, (rank, count) -> count + COUNT_OPERAND);
    }

    public int findResult(LottoRank lottoRank) {
        return this.matchResult.get(lottoRank);
    }

    public Map<LottoRank, Integer> getWinningResult() {
        return LottoRank.getWinningRank().stream()
                .collect(Collectors.toMap(Function.identity(), matchResult::get));
    }

    public int calculateTotalWinningMoney() {
        return this.getWinningResult().entrySet().stream()
                .map(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .reduce(0, Integer::sum);
    }
}
