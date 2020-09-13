package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoResult {

    private final int ROUNDING_DOWN_PLACE = 100;
    private final List<Prize> prizeResult;

    public LottoResult(List<Prize> prizeResult) {
        this.prizeResult = prizeResult;
    }

    public long getCountOfPrize(Prize prize) {
        return prizeResult.stream()
                .filter(p -> p.equals(prize))
                .count();
    }

    public double profitRate() {
        int payment = prizeResult.size() * Payment.TICKET_PRICE;
        int rewardTotal = prizeResult.stream()
                .mapToInt(Prize::getReward)
                .sum();
        return roundingDown((double) rewardTotal / payment);
    }

    private double roundingDown(double value) {
        return Math.floor(value * ROUNDING_DOWN_PLACE) / ROUNDING_DOWN_PLACE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return prizeResult.equals(that.prizeResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizeResult);
    }
}
