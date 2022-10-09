package step2.domian;

import java.util.List;

public class Calculator {

    public static final int THREE_REVENUE = 5000;
    public static final int FOUR_REVENUE = 50000;
    public static final int FIVE_REVENUE = 1500000;
    public static final int SIX_REVENUE = 2000000000;

    public static float calculatePercentage(int lottoPrice, int revenue) {
        return (float) revenue / (float) lottoPrice;
    }

    public static int calculateRevenue(List<Integer> results) {
        int result = 0;
        result += (THREE_REVENUE * results.get(3));
        result += (FOUR_REVENUE * results.get(4));
        result += (FIVE_REVENUE * results.get(5));
        result += (SIX_REVENUE * results.get(6));

        return result;
    }
}
