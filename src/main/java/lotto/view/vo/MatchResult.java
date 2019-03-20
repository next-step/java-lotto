package lotto.view.vo;

import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.WinningLotto;
import lotto.enums.Rank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class MatchResult {
    private WinningLotto winningLotto;
    private Map<Rank, Integer> ranks;

    public MatchResult(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        ranks = new HashMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> ranks.put(rank, 0));
    }

    public void calculate(List<BasicLotto> lottos) {
        ranks.forEach((key, value) -> ranks.put(key, match(lottos, key)));
    }

    private int match(List<BasicLotto> lottos, Rank matchRank) {
        return (int) lottos.stream()
            .filter(lotto -> matchRank.equals(winningLotto.match(lotto)))
            .count();
    }

    public double calculateTotalReward() {
        AtomicLong reward = new AtomicLong(0);
        ranks.forEach((key, value) -> reward.addAndGet(key.getTotalReward(value)));
        return reward.doubleValue();
    }

    public Map<Rank, Integer> getRanks() {
        return ranks;
    }
}
