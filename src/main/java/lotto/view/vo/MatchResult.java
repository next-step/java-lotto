package lotto.view.vo;

import lotto.domain.lotto.LottoBundle;
import lotto.domain.lotto.WinningLotto;
import lotto.enums.Rank;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class MatchResult {
    private WinningLotto winningLotto;
    private CountInfo countInfo;

    public MatchResult(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        countInfo = new CountInfo();
        Arrays.stream(Rank.values()).forEach(rank -> countInfo.put(rank, 0));
    }

    public void calculate(LottoBundle lottoBundle) {
        countInfo.getCounts().forEach((key, value) -> countInfo.put(key, match(lottoBundle, key)));
    }

    private int match(LottoBundle lottoBundle, Rank matchRank) {
        return (int) lottoBundle.getLottos().stream()
            .filter(lotto -> matchRank.equals(winningLotto.match(lotto)))
            .count();
    }

    public double calculateTotalReward() {
        AtomicLong reward = new AtomicLong(0);
        countInfo.getCounts().forEach((key, value) -> reward.addAndGet(key.getTotalReward(value)));
        return reward.doubleValue();
    }

    public CountInfo getCountInfo() {
        return countInfo;
    }
}
