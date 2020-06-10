package lotto.view;

import lotto.model.LottoNumber;
import lotto.model.Rank;
import lotto.model.RankReward;
import lotto.model.RewardStatus;

import java.util.List;

public class ResultView {

    private final String RESULT_MESSAGE = "당첨 통계.\n------";
    private final RewardStatus[] RewardList = { new RewardStatus(3, false),
                                            new RewardStatus(4, false),
                                            new RewardStatus(5, false),
                                            new RewardStatus(5, true),
                                            new RewardStatus(6, false) };

    public void displayLottoNumbers(List<LottoNumber> lottoNumberList){
        StringBuilder uiBuilder = new StringBuilder();
        for (LottoNumber lottoNumber : lottoNumberList) {
            uiBuilder.append("[" + lottoNumber.getLottoNumbertoString() + "]\n");
        }
        System.out.println(uiBuilder.toString());
    }

    public void displayResult(RankReward rankReward) {
        System.out.println(RESULT_MESSAGE);
        for (RewardStatus rewardStatus : RewardList) {
            int count = rankReward.getWinnerCount(rewardStatus);
            System.out.println(displayLottoRank(rewardStatus, count));
        }
    }

    public void displayResultRateMessage(float profitRate) {
        System.out.println("총 수익률은 " + getProfit(profitRate) + "입니다." + getProfitRateMessage(profitRate));
    }

    private String displayLottoRank (RewardStatus rewardStatus, int count) {
        return Rank.find(rewardStatus).getCountOfMatch()
                + "개 일치 "
                + ((rewardStatus.isMatchingBonus()) ? ", 보너스볼 일치" : "")
                + "(" + Rank.find(rewardStatus).getWinningMoney() + ") - " +count + "개";
    }

    private String getProfit(float profitRate) {
        return String.format("%.02f", profitRate);
    }

    private String getProfitRateMessage(float profitRate){
        if (profitRate == 1) {
            return "(기준이 1이기 때문에 결과적으로 본전이라는 의미임)";
        }
        if (profitRate < 1) {
            return "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        return "(기준이 1이기 때문에 결과적으로 이익이라는 의미임)";
    }

}