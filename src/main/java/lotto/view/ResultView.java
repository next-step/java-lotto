package lotto.view;

import lotto.model.LottoNumber;
import lotto.model.Rank;
import lotto.model.RankReward;

import java.util.List;

public class ResultView {

    private final String RESULT_MESSAGE = "당첨 통계.\n------";
    private int[] lottoRank = { 5, 4, 3, 2, 1 };

    public void displayLottoNumbers(List<LottoNumber> lottoNumberList){
        StringBuilder uiBuilder = new StringBuilder();
        for (LottoNumber lottoNumber : lottoNumberList) {
            uiBuilder.append("[" + lottoNumber.getLottoNumbertoString() + "]\n");
        }
        System.out.println(uiBuilder.toString());
    }

    public void displayResult(RankReward winnerCollection) {
        System.out.println(RESULT_MESSAGE);
        for (int ranking : lottoRank) {
            int count = winnerCollection.getWinnerCount(ranking);
            System.out.println(displayLottoRank(ranking, count));
        }

    }

    public void displayResultRateMessage(float profitRate) {
        System.out.println("총 수익률은 " + getProfit(profitRate) + "입니다." + getProfitRateMessage(profitRate));
    }

    private String displayLottoRank (int ranking, int count) {
        return Rank.find(ranking).getCountOfMatch()
                + "개 일치 "
                + ((ranking == 2) ? ", 보너스볼 일치" : "")
                + "(" + Rank.find(ranking).getWinningMoney() + ") - " +count + "개";
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