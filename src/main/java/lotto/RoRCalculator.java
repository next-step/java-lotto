package lotto;

public class RoRCalculator {

    private RoRCalculator() {
    }

    public static double calculateYield(int[] statistics) {
        int totalPrize = statistics[0] * 5000 + statistics[1] * 50000 + statistics[2] * 1500000 + statistics[3] * 30000000 + statistics[4] * 2000000000;
        return totalPrize / 14000.0 * 100;
    }
}
