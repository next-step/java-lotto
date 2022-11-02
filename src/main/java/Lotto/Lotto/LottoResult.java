package Lotto.Lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<LottoReward, Integer> rewardCountMap;
    private final LottoMoney lottoMoney;

    LottoResult(LottoMoney lottoMoney) {
        this.lottoMoney = lottoMoney;
        rewardCountMap = new HashMap<>();
    }

    LottoResult(LottoMoney lottoMoney, LottoTickets lottoTickets, LottoWinNumbers lottoWinNumbers) {
        this.lottoMoney = lottoMoney;
        rewardCountMap = new HashMap<>();
        for (LottoTicket lottoTicket: lottoTickets.getLottoTickets()) {
            LottoReward lottoReward = lottoTicket.match(lottoWinNumbers);
            this.increaseCount(lottoReward);
        }
    }

    public void setCount(LottoReward lottoReward, Integer count) {
        rewardCountMap.put(lottoReward, count);
    }

    public void increaseCount(LottoReward lottoReward) {
        rewardCountMap.put(lottoReward, this.getCount(lottoReward) + 1);
    }

    public Integer getCount(LottoReward lottoReward) {
        return rewardCountMap.getOrDefault(lottoReward, 0);
    }

    public Float profit() {
        float totalRewardMoney = 0f;
        for (Map.Entry<LottoReward, Integer> entry: rewardCountMap.entrySet()) {
            totalRewardMoney += entry.getValue() * entry.getKey().getRewardMoney();
        }
        return totalRewardMoney / lottoMoney.getBuyMoney();
    }
}
