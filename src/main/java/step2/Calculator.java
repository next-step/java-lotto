package step2;

import java.util.List;

public class Calculator {

    public static final int THREE_REVENUE = 5000;
    public static final int FOUR_REVENUE = 50000;
    public static final int FIVE_REVENUE = 1500000;
    public static final int SIX_REVENUE = 2000000000;

    public static int countSameNumber(List<Integer> lastWinner, List<Integer> lotto) {
        int sameCount = 0;
        for (int num : lastWinner) {
            sameCount += checkNumber(num, lotto);
        }
        return sameCount;
    }

    private static int checkNumber(int num, List<Integer> lotto) {
        if (lotto.contains(num)) {
            return 1;
        }
        return 0;
    }

    public static float calculatePercentage(int lottoPrice, int revenue) {
        return (float) revenue / (float) lottoPrice;
    }

    public static int calculateRevenue(int[] resultArray) {
        int result = 0;
        result += (THREE_REVENUE * resultArray[3]);
        result += (FOUR_REVENUE * resultArray[4]);
        result += (FIVE_REVENUE * resultArray[5]);
        result += (SIX_REVENUE * resultArray[6]);

        return result;
    }
}
