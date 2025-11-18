package lotto.domain;

public class LottoResult {

    public static double profitPercent(int buyPrice, int resultPrice) {
        return Math.floor((double) resultPrice / buyPrice * 100) / 100.0;
    }
}
