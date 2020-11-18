package step02.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoRewardCollections {
    private List<LottoReward> lottoRewards;

    private LottoRewardCollections(List<LottoReward> lottoRewards) {
        this.lottoRewards = lottoRewards;
    }

    public static LottoRewardCollections of(List<LottoReward> lottoRewards) {
        return new LottoRewardCollections(lottoRewards);
    }

    public LottoRewardCollections updateCounts(WinningCounterCollections winningCounterCollections) {
        return LottoRewardCollections.of(
                lottoRewards.stream().map(lottoReward -> {
                    int count = winningCounterCollections.getCount(lottoReward.getNumber());
                    return lottoReward.updateCount(count);
                }).collect(Collectors.toList())
        );
    }

    public int getReward() {
        int sum = 0;
        for (LottoReward lottoReward : lottoRewards) {
            sum += lottoReward.calcaulte();
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
        LottoRewardCollections that = (LottoRewardCollections) o;
        return Objects.equals(lottoRewards, that.lottoRewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoRewards);
    }

}
