package camp.nextstep.edu.nextstep8.lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoWinningResult {
    private static final int ZERO = 0;
    private final List<Integer> matchResult;

    public LottoWinningResult(List<Integer> matchResult) {
        this.matchResult = matchResult.stream()
                .filter(r -> r >= LottoAward.FOURTH.getCondition())
                .collect(Collectors.toList());
    }

    public int getWinningCount(LottoAward lottoAward) {
        return (int) matchResult.stream()
                .filter(r -> r == lottoAward.getCondition())
                .count();
    }

    public long getTotalReward() {
        if(emptyMatch()) {
            return 0;
        }

        return matchResult.stream()
                .mapToLong(r -> LottoAward.of(r).getPrize())
                .sum();
    }

    private boolean emptyMatch() {
        return ZERO == matchResult.size();
    }
}


