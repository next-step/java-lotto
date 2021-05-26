package lotto.view;

import lotto.model.config.LottoConfig;

import java.math.BigDecimal;

public class ViewOutput {
    public static String EARN = "이득";
    public static String EVEN = "본전";
    public static String LOSS = "손해";

    public static void printlnResult(Integer numMatched, Integer numMatchedLottonumbers) {

        int rewardPrice = LottoConfig.winningRewards.getOrDefault(numMatched, 0);
        if(rewardPrice == 0){
            return;
        }
        String message = String.format("%s개 일치 (%s원)- %s개", numMatched,
                rewardPrice, numMatchedLottonumbers);
        System.out.println(message);
    }

    public static void printlnProfitRate(BigDecimal profitRate) {
        String message = String.format("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", profitRate, getResultStatus(profitRate));
        System.out.println(message);
    }

    public static String getResultStatus(BigDecimal profitRate){
        if (profitRate.doubleValue() > 1){
            return EARN;
        }
        if(profitRate.doubleValue() == 0){
            return EVEN;
        }
        return LOSS;
    }
}
