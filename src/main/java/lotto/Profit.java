package lotto;

import java.math.BigDecimal;

public class Profit {


    public static double getLottoGameProfit(LottoTicket lottoTicket){
        double totalWinnerPriceAmt = 0;
        for(Rank rank : lottoTicket.getLottoRankList()){
            totalWinnerPriceAmt += rank.getWinnnerPrice();
        }
        double lottoBuyAmt = LottoGameService.getLottoBuyAmt();
        BigDecimal profitRate = new BigDecimal(totalWinnerPriceAmt / lottoBuyAmt).setScale(2, BigDecimal.ROUND_FLOOR);
        return profitRate.doubleValue();
    }
}
