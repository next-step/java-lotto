package lotto.view;

import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.model.ScoreMap;
import lotto.model.config.LottoConfig;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ConsoleView {
    private final static String EARN = "이득";
    private final static String EVEN = "본전";
    private final static String LOSS = "손해";
    private final static String MATCH_MESSAGE = "%s개 일치 (%s원)- %s개";
    private final static String PROFIT_MESSAGE = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";

    public ConsoleView() {
    }


//    public ConsoleView(LottoResult lottoResult) {
//        this.lottoResult = lottoResult;
//    }

    public void printLotto(List<LottoTicket> lottoTickets){
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }
    }

    public void print(LottoResult lottoResult) {
        printScoreMap(lottoResult);
        printResult(lottoResult);
    }

    private void printScoreMap(LottoResult lottoResult){
        ScoreMap scoreMap = lottoResult.getScoreMap();
        for( Map.Entry<Integer, Integer> lottoResultItem : scoreMap.getEntrySet() ){
            int numMatched = lottoResultItem.getKey();
            int numMatchedLottoNumbers = lottoResultItem.getValue();
            int rewardPrice = LottoConfig.winningRewards.getOrDefault(numMatched, 0);
            if(rewardPrice == 0){
                continue;
            }
            String message = String.format(MATCH_MESSAGE, numMatched,
                    rewardPrice, numMatchedLottoNumbers);
            System.out.println(message);
        }

    }

    private void printResult(LottoResult lottoResult){
        BigDecimal profitRate = calculateProfitRatio(lottoResult.getTotalReward(), lottoResult.getExpense());
        String message = String.format(PROFIT_MESSAGE, profitRate, getResultStatus(profitRate));
        System.out.println(message);
    }

    public BigDecimal calculateProfitRatio(int totalProfit, int expense){
        if(totalProfit == 0 || expense == 0){

            return new BigDecimal(0);
        }
        return new BigDecimal(totalProfit).divide(new BigDecimal(expense), 4, BigDecimal.ROUND_CEILING);
    }

    public static String getResultStatus(BigDecimal profitRate){
        if (profitRate.doubleValue() > 1){
            return EARN;
        }
        if(profitRate.doubleValue() == 1){
            return EVEN;
        }
        return LOSS;
    }
}
