package lotto.domain.lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.common.Rank;

public class LottoResult {

    private final List<Lotto> purchasedLottos;
    private final WinningLotto winningLotto;

    public LottoResult(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        this.purchasedLottos = purchasedLottos;
        this.winningLotto = winningLotto;
    }

    public double getEarningRate() {
        Map<Integer, Integer> matchCounts = getMatchLottoCounts();
        int prizeMoney = matchCounts.keySet().stream()
            .mapToInt(matchCount -> Rank.valueOf(matchCount).getWinningMoney() * matchCounts.get(matchCount))
            .sum();

        return prizeMoney / (double) LottoFactory.calculateTotalAmount(purchasedLottos.size());
    }

    public Map<Integer, Integer> getMatchLottoCounts() {
        Map<Integer, Integer> matchLottoCounts = new HashMap<Integer, Integer>() {{
            put(3, 0);
            put(4, 0);
            put(5, 0);
            put(6, 0);
        }};
        purchasedLottos.stream()
            .map(winningLotto::matchNumberCount)
            .filter(matchCount -> matchCount > 2)
            .forEach(matchCount -> matchLottoCounts.put(matchCount, matchLottoCounts.get(matchCount) + 1));

        return Collections.unmodifiableMap(matchLottoCounts);
    }
}
