package lotto;

import java.math.BigDecimal;
import java.util.List;

public class Profit {


    public static double getLottoGameProfit(List<Rank> lottoRankList){
        double totalWinnerPriceAmt = 0;
        for(Rank rank : lottoRankList){
            totalWinnerPriceAmt += rank.getWinnnerPrice();
        }
        double lottoBuyAmt = LottoGameService.getLottoBuyAmt();
        BigDecimal profitRate = new BigDecimal(totalWinnerPriceAmt / lottoBuyAmt).setScale(2, BigDecimal.ROUND_FLOOR);
        return profitRate.doubleValue();
    }
}
