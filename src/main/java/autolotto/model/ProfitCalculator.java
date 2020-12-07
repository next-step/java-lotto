package autolotto.model;

import java.util.HashMap;

public class ProfitCalculator {

    static final int THREE_MATCH_PROFIT = 5000;
    static final int FOUR_MATCH_PROFIT = 50000;
    static final int FIVE_MATCH_PROFIT = 1500000;
    static final int SIX_MATCH_PROFIT = 2000000000;
    static int profit = 0;

    public static float calculate(int money, LottosComparer matchingNumbers) {
        for (int i = 3; i < 7; i++) {
            addProfit(i,matchingNumbers.getMatchingCount(i));
        }

        return profit / (float)money;
    }

    private static void addProfit(int matchingNumber, int matchingCount){
        switch (matchingNumber){
            case 3 :
                profit += THREE_MATCH_PROFIT * matchingCount;
                break;
            case 4 :
                profit += FOUR_MATCH_PROFIT * matchingCount;
                break;
            case 5 :
                profit += FIVE_MATCH_PROFIT * matchingCount;
                break;
            case 6 :
                profit += SIX_MATCH_PROFIT * matchingCount;
                break;
        }
    }
}
