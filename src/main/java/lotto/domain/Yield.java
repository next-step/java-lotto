package lotto.domain;

public class Yield {

    public static double getYield(int buyAmount, long winningAmount) {
        return winningAmount / (double) buyAmount;
    }

}
