package lotto.view;

import lotto.model.*;

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

    private static String LottoNumbersToLineString(List<LottoNumber> lottoNumbers){
        StringJoiner strJoiner = new StringJoiner(",");
        for (LottoNumber lottoNubmer : lottoNumbers) {
            strJoiner.add( Integer.toString(lottoNubmer.number()) );
        }
        return "[" + strJoiner.toString() + "]";
    }

    public static void printScoreMap(LottoResult lottoResult){
        ScoreMap scoreMap = lottoResult.getScoreMap();
        for(LottoRank lottoRank : scoreMap.getKeySet() ){
            if(lottoRank == null){
                continue;
            }
            String message = String.format(MATCH_MESSAGE, lottoRank.getMatchCount(),
                    lottoRank.getPrize(), scoreMap.getNumMatchCount(lottoRank));
            System.out.println(message);
        }
    }

    public static void printResult(LottoResult lottoResult){
        BigDecimal profitRate = calculateProfitRatio(lottoResult.getScoreMap().sumRewards(), lottoResult.getExpense());
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
