package step02.domain;

import java.util.Objects;

public class WinningStatistic {
    private final LottoRewardCollections lottoRewards;
    private final Lotto winningNumbers;
    private final Lottos userLottos;

    private WinningStatistic(Lotto winningNumbers, Lottos userLottos, LottoRewardCollections lottoRewards) {
        this.winningNumbers = winningNumbers;
        this.userLottos = userLottos;
        this.lottoRewards = lottoRewards;
    }

    public static WinningStatistic of(Lotto winningNumbers, Lottos userLottos, LottoRewardCollections lottoRewards) {
        return new WinningStatistic(winningNumbers, userLottos, lottoRewards);
    }

    public WinningStatistic execute() {
        WinningCounterCollections winningCounters = userLottos.statisticWinning(winningNumbers);
        return WinningStatistic.of(winningNumbers, userLottos, lottoRewards.updateCounts(winningCounters));
    }

    public int getMatchCount() {
        return 0;
    }

    public int getReward() {
        return 0;
    }

    public int getTarget() {
        return 0;
    }

    public double calculate(int lottoPrice) {
        double spent = lottoPrice * userLottos.getCount();
        double reward = lottoRewards.getReward();
        return Math.floor(reward / spent * 100) / 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningStatistic that = (WinningStatistic) o;
        return Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers);
    }

}
