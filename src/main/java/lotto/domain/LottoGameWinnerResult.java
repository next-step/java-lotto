package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.enumeration.LottoReward;

public class LottoGameWinnerResult {

    private final Map<LottoReward, Integer> rewardHitCountMap = new HashMap<>();
    private int rewardMoneySum;
    private double profitRate;

    public void updateResultInfo(LottoReward reward, int playerTicketsCount) {
        upOneRewardHitCount(reward);
        updateRewardMoneySum(reward);
        updateProfitRate(playerTicketsCount);
    }

    private void updateProfitRate(int playerTicketsCount) {

        int investedMoney = (LottoTicket.PRICE * playerTicketsCount);

        profitRate = rewardMoneySum / investedMoney;
    }

    private void updateRewardMoneySum(LottoReward reward) {
        this.rewardMoneySum += reward.getRewardMoney();
    }

    private void upOneRewardHitCount(LottoReward reward) {
        rewardHitCountMap.merge(reward, 1, Integer::sum);
    }

    public int getHitCountByReward(LottoReward reward) {
        return rewardHitCountMap.getOrDefault(reward, 0);
    }

    public int getRewardMoneySum() {
        return rewardMoneySum;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
