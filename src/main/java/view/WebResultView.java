package view;

import domain.LottoRank;
import domain.LottoResultGroup;
import domain.wrapper.EarningRate;

import java.util.ArrayList;
import java.util.List;

public class WebResultView {

    public static String getString(LottoResultGroup combineLottoGroup, LottoRank rank) {
        String result = "";
        int lottoCount = combineLottoGroup.getCombineNumbers(rank);

        result+=String.format("%s개 일치", rank.getCombineNum());
        if(rank.equals(LottoRank.SECOND_PRICE)) {
            result+=   ", 보너스 볼 일치";
        }
        result+=  String.format(" (%s원)", rank.getPriceRewards());
        result+= String.format("- %s개", lottoCount);
        return result;
    }


    public static String getTotalRate(EarningRate totalEarningRate) {
        return String.format("총 수익률은 %s", (int)totalEarningRate.getEarningRate() * 100) + "%입니다.";
    }

    public static List<String> getResults(LottoResultGroup combineLottoGroup) {
        List<String> lottoRankResults = new ArrayList<>();
        for(LottoRank rank :  LottoRank.values()){
            String result = WebResultView.getString(combineLottoGroup, rank);
            lottoRankResults.add(result);
        }
        return lottoRankResults;
    }
}
