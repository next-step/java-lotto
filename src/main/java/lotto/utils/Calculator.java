package lotto.utils;

public class Calculator {

    public static double calculateRateOfReturn(int amount, int prizeMoney) {
        double result = prizeMoney / (double) amount;
        return Math.floor(result * 100) / 100.0;
    }
}
