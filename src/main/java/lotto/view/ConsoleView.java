package lotto.view;

import lotto.model.LottoNumber;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.model.ScoreMap;
import lotto.model.config.LottoConfig;

import java.math.BigDecimal;
import java.util.*;

public class ConsoleView {
    private final static String EARN = "이득";
    private final static String EVEN = "본전";
    private final static String LOSS = "손해";
    private final static String MATCH_MESSAGE = "%s개 일치 (%s원)- %s개";
    private final static String PROFIT_MESSAGE = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";

    public ConsoleView() {
    }

    public static void printLotto(List<LottoTicket> lottoTickets){
        for (LottoTicket lottoTicket : lottoTickets) {
            List<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers();
            List<LottoNumber> copyedLottoNumbers = new ArrayList(lottoNumbers);
            Collections.sort(copyedLottoNumbers);
            System.out.println(LottoNumbersToLineString(copyedLottoNumbers));
        }
    }

    public static String LottoNumbersToLineString(List<LottoNumber> lottoNumbers){
        StringJoiner strJoiner = new StringJoiner(",");
        for (LottoNumber lottoNubmer : lottoNumbers) {
            strJoiner.add( Integer.toString(lottoNubmer.number()) );
        }
        return "[" + strJoiner.toString() + "]";
    }

    public static void print(LottoResult lottoResult) {
        printScoreMap(lottoResult);
        printResult(lottoResult);
    }

    public static void printScoreMap(LottoResult lottoResult){
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

    public static void printResult(LottoResult lottoResult){
        BigDecimal profitRate = calculateProfitRatio(lottoResult.getScoreMap().calculateReward(), lottoResult.getExpense());
        String message = String.format(PROFIT_MESSAGE, profitRate.toPlainString(), getResultStatus(profitRate));
        System.out.println(message);
    }

    public static BigDecimal calculateProfitRatio(int totalProfit, int expense){
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
