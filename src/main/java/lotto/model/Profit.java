package lotto.model;

import java.util.List;
import java.util.Objects;

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
        return THREE.calculatePrice(matchingNumbers.get(0))
                + FOUR.calculatePrice(matchingNumbers.get(1))
                + FIVE.calculatePrice(matchingNumbers.get(2))
                + SIX.calculatePrice(matchingNumbers.get(3));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profit profit = (Profit) o;
        return lottoQuantity == profit.lottoQuantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoQuantity);
    }
}
