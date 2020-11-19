package step02.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoRewards {
    private List<LottoReward> lottoRewards;

    private LottoRewards(List<LottoReward> lottoRewards) {
        this.lottoRewards = lottoRewards;
    }

    public static LottoRewards of(List<LottoReward> lottoRewards) {
        return new LottoRewards(lottoRewards);
    }

    public LottoRewards updateCounts(WinningCounters winningCounters) {
        return LottoRewards.of(
                lottoRewards.stream().map(lottoReward -> {
                    int count = winningCounters.getCount(lottoReward.getNumber());
                    return lottoReward.updateCount(count);
                }).collect(Collectors.toList())
        );
    }

    public int getReward() {
        int sum = 0;
        for (LottoReward lottoReward : lottoRewards) {
            sum += lottoReward.calculate();
        }
        return sum;
    }

    public List<LottoReward> getLottoRewards() {
        return lottoRewards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoRewards that = (LottoRewards) o;
        return Objects.equals(lottoRewards, that.lottoRewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoRewards);
    }

}
