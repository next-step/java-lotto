package step2_2;

import java.util.List;

public class LottoResult {

    private List<LottoReward> rewards;
    private Money money;

    public LottoResult(List<LottoReward> rewards, Money money) {
        this.rewards = rewards;
        this.money = money;
    }
}
