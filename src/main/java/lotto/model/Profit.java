package lotto.model;

import java.util.List;

public class Profit {
    public static final int LOTTO_PRICE = 1000;
    private static final int SAME_THREE_NUMBER_PRICE = 5000;
    private static final int SAME_FOUR_NUMBER_PRICE = 50000;
    private static final int SAME_FIVE_NUMBER_PRICE = 1500000;
    private static final int SAME_SIX_NUMBER_PRICE = 2000000000;
    private final int lottoQuantity;

    public Profit(int lottoQuantity) {
        this.lottoQuantity = lottoQuantity;
    }

    public double calculate(List<Integer> matchingNumbers) {
        double sum = getAllMatchPrice(matchingNumbers);

        if (isNothingMatch(sum)) {
            return 0;
        }
        return profit(sum);
    }

    private double profit(double sum) {
        return sum / (lottoQuantity * LOTTO_PRICE);
    }

    private boolean isNothingMatch(double sum) {
        return sum == 0;
    }

    private int getAllMatchPrice(List<Integer> matchingNumbers) {
        return matchingNumbers.get(0) * SAME_THREE_NUMBER_PRICE
                + matchingNumbers.get(1) * SAME_FOUR_NUMBER_PRICE
                + matchingNumbers.get(2) * SAME_FIVE_NUMBER_PRICE
                + matchingNumbers.get(3) * SAME_SIX_NUMBER_PRICE;
    }
}
