package lotto.model;

public class RateOfReturn {

    public static double calculate(LottoResult lottoResult) {
        Money totalBuyMoney = lottoResult.calculateTotalBuyMoney();
        Money totalOfPrize = lottoResult.calculateTotalWinningMoney();
        return totalBuyMoney.divide(totalOfPrize);
    }
}