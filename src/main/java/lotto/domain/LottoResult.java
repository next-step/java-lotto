package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResult {

    private static final int ROUNDING = 2;
    private final Map<Prize, Long> prizeResult;

    public LottoResult(Map<Prize, Long> prizeResult) {
        this.prizeResult = prizeResult;
    }

    public static LottoResult of(Lottos lottos, WinningLotto winningLotto) {
        List<Hit> hitList = lottos.matchHit(winningLotto);
        return new LottoResult(hitList.stream()
                .map(Prize::of)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }

    public long counts(Prize prize) {
        return prizeResult.getOrDefault(prize, 0L);
    }

    public BigDecimal earningRate(BigDecimal price) {
        return profit().divide(price, ROUNDING, RoundingMode.HALF_EVEN);
    }

    private BigDecimal profit() {
        BigDecimal total = BigDecimal.ZERO;
        for (Map.Entry<Prize, Long> entry : prizeResult.entrySet()) {
            Prize prize = entry.getKey();
            total = total.add(BigDecimal.valueOf(prize.getReward() * entry.getValue()));
        }
        return total;
    }

}
