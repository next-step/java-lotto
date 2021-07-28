package lotto.domain.lotto;

import static lotto.common.Properties.LOTTO_PRICE;
import static lotto.common.Properties.LOTTO_PRIZE_MONEYS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Long, Integer> matchLottoCounts = new HashMap<Long, Integer>() {{
        put(3L, 0);
        put(4L, 0);
        put(5L, 0);
        put(6L, 0);
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
            .mapToLong(key -> LOTTO_PRIZE_MONEYS.get(key) * matchLottoCounts.get(key))
            .sum();

        return prizeMoney / (double) (LOTTO_PRICE * purchaseLottoCount);
    }

    public Map<Long, Integer> getMatchLottoCounts() {
        return matchLottoCounts;
    }

    public double getEarningRate() {
        return earningRate;
    }
}
