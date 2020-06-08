package step2.model;

import java.util.Arrays;
import java.util.Collections;
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

    public Money calculateTotalWinningMoney() {
        int winningMoney = this.matchResult.entrySet().stream()
                .map(this::multiplyWinningMoney)
                .reduce(0, Integer::sum);

        return Money.valueOf(winningMoney);
    }

    private int multiplyWinningMoney(Map.Entry<LottoRank, Integer> entry) {
        return entry.getKey().getWinningMoney() * entry.getValue();
    }
}
