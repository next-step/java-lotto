package lotto.domain.lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.common.Rank;

public class LottoResult {

    private final List<NormalLotto> purchasedLottos;
    private final WinningLotto winningLotto;

    public LottoResult(List<NormalLotto> purchasedLottos, WinningLotto winningLotto) {
        this.purchasedLottos = purchasedLottos;
        this.winningLotto = winningLotto;
    }

    public double getEarningRate() {
        Map<Rank, Integer> winningLottoCounts = getWinningLottoCounts();
        int prizeMoney = winningLottoCounts.keySet().stream()
            .mapToInt(matchCount -> matchCount.getWinningMoney() * winningLottoCounts.get(matchCount))
            .sum();

        return prizeMoney / (double) LottoFactory.calculateTotalAmount(purchasedLottos.size());
    }

    public Map<Rank, Integer> getWinningLottoCounts() {
        Map<Rank, Integer> winningLottoCounts = Arrays.stream(Rank.values())
            .collect(Collectors.toMap(r -> r, r -> 0));
        purchasedLottos.stream()
            .map(lotto -> Rank.valueOf(winningLotto.matchNumberCount(lotto), winningLotto.matchBonusNumber(lotto)))
            .forEach(matchCount -> winningLottoCounts.put(matchCount, winningLottoCounts.get(matchCount) + 1));

        return Collections.unmodifiableMap(winningLottoCounts);
    }
}
