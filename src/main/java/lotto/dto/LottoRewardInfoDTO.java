package lotto.dto;

import lotto.domain.LottoReward;

import java.util.Objects;

public class LottoRewardInfoDTO {
    private final LottoReward reward;
    private final int count;

    private LottoRewardInfoDTO(int count, LottoReward reward) {
        this.count = count;
        this.reward = reward;
    }

    public static LottoRewardInfoDTO valueOf(int count, LottoReward reward) {
        return new LottoRewardInfoDTO(count, reward);
    }

    public int getCount() {
        return count;
    }

    public LottoReward getReward() {
        return reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoRewardInfoDTO that = (LottoRewardInfoDTO) o;
        return getCount() == that.getCount() && getReward() == that.getReward();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReward(), getCount());
    }
}
