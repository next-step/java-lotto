package lotto.model;

import java.util.Arrays;
import java.util.List;

public class UserLotto {

    private List<Lotto2> lottos;

    public UserLotto(List<Lotto2> lottos) {
        this.lottos = lottos;
    }

    public int matchCount(WinningLotto winningLotto, Level2 level) {
        return (int) lottos.stream()
                .filter(it -> it.match(winningLotto) == level.getValue())
                .count();
    }

    public double getTotAteOfReturn(WinningLotto winningLotto, long purchaseAmount) {
        long totalWinningAmount = Arrays.stream(Level2.values())
                .map(it -> matchCount(winningLotto, it) * it.getAmount())
                .reduce(0L, Long::sum);

        return Math.round(((double)totalWinningAmount / purchaseAmount) * 100) / 100.0;
    }
}
