package lotto.model;

import java.util.Arrays;
import java.util.List;

public class UserLotto {

    private List<Lotto> lottos;

    public UserLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int matchCount(WinningLotto winningLotto, Level level) {
        return (int) lottos.stream()
                .filter(it -> it.match(winningLotto) == level.getValue())
                .count();
    }

    public double getTotalRateOfReturn(WinningLotto winningLotto, long purchaseAmount) {
        long totalWinningAmount = Arrays.stream(Level.values())
                .map(it -> matchCount(winningLotto, it) * it.getAmount())
                .reduce(0L, Long::sum);

        return Math.round(((double)totalWinningAmount / purchaseAmount) * 100) / 100.0;
    }
}
