package camp.nextstep.edu.nextstep8.lotto;

import java.util.Arrays;
import java.util.Comparator;
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

    public String getResultForPrint() {
        StringBuilder output = new StringBuilder();

        Arrays.stream(LottoAward.values())
                .sorted(Comparator.comparingInt(LottoAward::getCondition))
                .forEach(e -> {
                    output.append(e.getCondition() + "개 일치 (" + e.getPrize() + "원) -\t");
                    output.append(getWinningCount(e) + "개 \n");
                });
        return output.toString();
    }
}


