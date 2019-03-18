package lotto.view.vo;

import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.WinningLotto;
import lotto.enums.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class MatchResult {
    private WinningLotto winningLotto;
    private Map<Rank, Integer> rank;

    public MatchResult(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        rank = new HashMap<>();
        rank.put(Rank.FIRST, 0);
        rank.put(Rank.SECOND, 0);
        rank.put(Rank.THIRD, 0);
        rank.put(Rank.FOURTH, 0);
        rank.put(Rank.FIFTH, 0);
        rank.put(Rank.MISS, 0);
    }

    public void calculate(List<BasicLotto> lottos) {
        rank.forEach((key, value) -> rank.put(key, match(lottos, key)));
    }

    private int match(List<BasicLotto> lottos, Rank matchRank) {
        return (int) lottos.stream()
            .filter(lotto -> matchRank.equals(winningLotto.match(lotto)))
            .count();
    }

    public long calculateTotalReward() {
        AtomicLong reward = new AtomicLong(0L);
        rank.forEach((key, value) -> reward.addAndGet(key.getTotalReward(value)));
        return reward.longValue();
    }

    public Map<Rank, Integer> getRank() {
        return rank;
    }
}
