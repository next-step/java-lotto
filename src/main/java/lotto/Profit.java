package lotto;

import java.math.BigDecimal;

public class Profit {


    public static double getLottoGameProfit(){
        double totalWinnerPriceAmt = 0;
        for(Lotto lotto : LottoGameService.getBuyLotto()){
            totalWinnerPriceAmt += lotto.getRank().getWinnnerPrice();
        }
        double lottoBuyAmt = LottoGameService.getLottoBuyAmt();
        BigDecimal profitRate = new BigDecimal(totalWinnerPriceAmt / lottoBuyAmt).setScale(2, BigDecimal.ROUND_FLOOR);
        return profitRate.doubleValue();
    }
    public static String profitToString(double profitRate) {
        if (profitRate >= 1) {
            return "이득이";
        }
        return "손해";
    }
}
