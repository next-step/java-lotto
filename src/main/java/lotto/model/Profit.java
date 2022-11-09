package lotto.model;

import java.util.List;

import static lotto.model.Rank.*;

public class Profit {
    public static final int LOTTO_PRICE = 1000;
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
        return THREE.getAllMatchPrice(matchingNumbers.get(0))
                + FOUR.getAllMatchPrice(matchingNumbers.get(1))
                + FIVE.getAllMatchPrice(matchingNumbers.get(2))
                + SIX.getAllMatchPrice(matchingNumbers.get(3));
    }
}
