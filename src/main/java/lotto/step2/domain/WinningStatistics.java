package lotto.step2.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WinningStatistics {

    private static final long PRICE_PER_LOTTO = 1000;
    private static final int SCALE = 2;

    private final Map<Rank, Integer> winningStatistics = new HashMap<>();
    private final int lottoCount;

    public WinningStatistics(Lottos lottos, Lotto winningLotto) {
        Arrays.stream(Rank.values())
                .forEach(rank -> winningStatistics.put(rank, 0));
        lottos.lottos()
                .forEach(lotto -> hit(lotto.match(winningLotto)));
        lottoCount = lottos.lottos().size();
    }

    public Map<Rank, Integer> statistics() {
        return Collections.unmodifiableMap(winningStatistics);
    }

    public void hit(long hit) {
        Rank rank = Rank.from(hit);
        winningStatistics.put(rank, winningStatistics.get(rank) + 1);
    }

    private long sum() {
        long sum = 0;
        for(Rank rank : winningStatistics.keySet()) {
            long multiple = rank.amount() * winningStatistics.get(rank);
            sum += multiple;
        }
        return sum;
    }

    public double profits() {
        BigDecimal purchasingAmount = BigDecimal.valueOf(lottoCount * PRICE_PER_LOTTO);
        return BigDecimal.valueOf(sum())
                .divide(purchasingAmount,SCALE,BigDecimal.ROUND_DOWN)
                .doubleValue();
    }

}
