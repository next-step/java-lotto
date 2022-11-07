package lotto.lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<LottoReward, Integer> rewardCountMap = new HashMap<>();

    private LottoResult() {
    }

    public static LottoResult of(LottoTickets lottoTickets, LottoWinNumbers lottoWinNumbers) {
        LottoResult lottoResult = new LottoResult();
        for (LottoTicket lottoTicket: lottoTickets.getLottoTickets()) {
            LottoReward lottoReward = lottoTicket.match(lottoWinNumbers);
            lottoResult.increaseCount(lottoReward);
        }
        return lottoResult;
    }

    public static LottoResult of(final Integer fourthCount, final Integer thirdCount,
                                 final Integer secondCount, final Integer firstCount) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.setCount(LottoReward.FOURTH, fourthCount);
        lottoResult.setCount(LottoReward.THIRD, thirdCount);
        lottoResult.setCount(LottoReward.SECOND, secondCount);
        lottoResult.setCount(LottoReward.FIRST, firstCount);
        return lottoResult;
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

    public Float profit(LottoMoney lottoMoney) {
        float totalRewardMoney = 0f;
        for (Map.Entry<LottoReward, Integer> entry: rewardCountMap.entrySet()) {
            totalRewardMoney += entry.getValue() * entry.getKey().getRewardMoney();
        }
        return totalRewardMoney / lottoMoney.getBuyMoney();
    }
}
