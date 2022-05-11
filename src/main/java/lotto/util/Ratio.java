package lotto.util;

public class Ratio {

    public static double lottoEarningRatio(double earnings, double price) {
        return Math.floor((earnings / price) * 100) / 100.0;
    }
}
