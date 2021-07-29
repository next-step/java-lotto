package lotto.domain.lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.common.LottoPrizeMoney;

public class LottoResult {

    private final Map<Integer, Integer> matchLottoCounts = new HashMap<Integer, Integer>() {{
        put(3, 0);
        put(4, 0);
        put(5, 0);
        put(6, 0);
    }};
    private final double earningRate;

    public LottoResult(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        purchasedLottos.stream()
            .map(winningLotto::matchNumberCount)
            .filter(matchCount -> matchCount > 2)
            .forEach(matchCount -> this.matchLottoCounts.put(matchCount, this.matchLottoCounts.get(matchCount) + 1));

        this.earningRate = calculateEarningRate(purchasedLottos.size());
    }

    private double calculateEarningRate(int purchaseLottoCount) {
        long prizeMoney = matchLottoCounts.keySet().stream()
            .mapToLong(key -> LottoPrizeMoney.findByMatchNumberCount(key) * matchLottoCounts.get(key))
            .sum();

        return prizeMoney / (double) (LottoFactory.getLottoPrice() * purchaseLottoCount);
    }

    public Map<Integer, Integer> getMatchLottoCounts() {
        return Collections.unmodifiableMap(matchLottoCounts);
    }

    public double getEarningRate() {
        return earningRate;
    }
}
