package lotto.domain;

public class Yield {

    public static double calculateYield(int buyAmount, long winningAmount) {
        return winningAmount / (double) buyAmount;
    }

}
