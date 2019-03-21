package util;

import domain.PrizeMoney;

import java.util.Map;

public class Calculator {

    public static double yieldCalculator(Map<Integer, Integer> produceResults, int investment) {
        int revenue = nullToZero(produceResults.get(3)) * PrizeMoney.THREE.getPrice()
                    + nullToZero(produceResults.get(4)) * PrizeMoney.FOUR.getPrice()
                    + nullToZero(produceResults.get(5)) * PrizeMoney.FIVE.getPrice()
                    + nullToZero(produceResults.get(6)) * PrizeMoney.SIX.getPrice();
        return (double) revenue / investment;
    }

    public static int nullToZero(Integer number) {
        return number == null ? 0 : number;
    }
}
