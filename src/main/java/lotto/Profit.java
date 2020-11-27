package lotto;

import java.math.BigDecimal;

public class Profit {


    public static double getLottoGameProfit(){
        double totalWinnerPriceAmt = 0;
        for(Lotto lotto : LottoGameService.getBuyLotto().getLottoList()){
            totalWinnerPriceAmt += lotto.getRank().getWinnnerPrice();
        }
        double lottoBuyAmt = LottoGameService.getLottoBuyAmt();
        BigDecimal profitRate = new BigDecimal(totalWinnerPriceAmt / lottoBuyAmt).setScale(2, BigDecimal.ROUND_FLOOR);
        return profitRate.doubleValue();
    }
}
