package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResult {

    private final Map<Prize, Long> prizeResult;

    public LottoResult(Map<Prize, Long> prizeResult) {
        this.prizeResult = prizeResult;
    }

    public static LottoResult of(Lottos lottos, WinningLotto winningLotto) {
        List<Integer> winningCounts = lottos.match(winningLotto);
        return new LottoResult(winningCounts.stream()
                .map(Prize::of)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }

    public long counts(Prize prize) {
        return prizeResult.getOrDefault(prize, 0L);
    }

    public double profit() {
        long total = 0;
        for (Map.Entry<Prize, Long> entry : prizeResult.entrySet()) {
            Prize prize = entry.getKey();
            total += prize.getReward() * entry.getValue();
        }
        return total;
    }

}
