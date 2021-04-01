package step2.util;

public class PrizeCalculatorUtil {

    private static final int LOTTO_PRIZE = 1000;

    public static int getLottoCount(int monney) {
        return monney / LOTTO_PRIZE;
    }

    public static double profitCalculation(int total, int lottoCount){
        return (double) total / (lottoCount * LOTTO_PRIZE);
    }
}
