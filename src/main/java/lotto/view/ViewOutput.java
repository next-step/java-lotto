package lotto.view;

import lotto.model.config.LottoConfig;

public class ViewOutput {

    public static void printlnResult(Integer numMatched, Integer numMatchedLottonumbers) {

        int rewardPrice = LottoConfig.winningRewards.getOrDefault(numMatched, 0);
        if(rewardPrice == 0){
            return;
        }
        String message = String.format("%s개 일치 (%s원)- %s개", numMatched,
                rewardPrice, numMatchedLottonumbers);
        System.out.println(message);
    }

    public static void printlnProfitRate(int profitRate) {
        String message = String.format("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", profitRate);
        System.out.println(message);
    }
}
