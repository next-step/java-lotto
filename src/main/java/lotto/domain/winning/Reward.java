package lotto.domain.winning;

import lotto.domain.Amount;
import lotto.domain.rating.WinningRatingType;

public class Reward {
    private int reward;

    public void plusReward(WinningRatingType type) {
        reward += type.getReward();
    }

    public float rateOfReturn(Amount amount) {
        return (float) (Math.floor(((float) this.reward / amount.getAmount() * 100)) / 100.0);
    }
}
