package lotto.domain;

public class Ratio {

    public double lottoPer(double earnings, double price) {
        return Math.floor((earnings / price) * 100) / 100.0;
    }
}
