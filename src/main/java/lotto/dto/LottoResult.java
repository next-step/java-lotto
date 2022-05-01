package lotto.dto;

import lotto.model.Rank;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class LottoResult {
    private static final int WINNINGS_START = 3;
    private static final int WINNINGS_END = 6;
    private static final int ZERO = 0;

    private final Map<Rank, Integer> rankResult;
    private final long winningsSum;

    public LottoResult(Map<Rank, Integer> rankResult, long winningsSum) {
        validate(rankResult, winningsSum);
        this.rankResult = initRankResult(rankResult);
        this.winningsSum = winningsSum;
    }

    private Map<Rank, Integer> initRankResult(Map<Rank, Integer> rankResult) {
        removeOtherRank(rankResult);
        fillRankDefault(rankResult);
        return rankResult;
    }

    private void fillRankDefault(Map<Rank, Integer> rankResult) {
        for (int i = WINNINGS_START; i <= WINNINGS_END; i++) {
            Rank rank = Rank.of(i);
            rankResult.put(rank, rankResult.getOrDefault(rank, 0));
        }
    }

    private void removeOtherRank(Map<Rank, Integer> rankResult) {
        if (rankResult.containsKey(Rank.OTHER)) {
            rankResult.remove(Rank.OTHER);
        }
    }

    private void validate(Map<Rank, Integer> rankResult, long winningsSum) {
        Objects.requireNonNull(rankResult, "로또 결과 생성 입력값이 올바르지 않습니다. rankResult is null");
        if (isNegative(winningsSum)) {
            throw new IllegalArgumentException("로또 상금 합계는 음수일 수 없습니다. winningsSum: " + winningsSum);
        }
    }

    private boolean isNegative(long winningsSum) {
        return winningsSum < ZERO;
    }

    public Map<Rank, Integer> getRankResult() {
        return Collections.unmodifiableMap(rankResult);
    }

    public long getWinningsSum() {
        return winningsSum;
    }
}
