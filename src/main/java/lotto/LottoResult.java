package lotto;

import java.util.Map;
import java.util.Objects;

public class LottoResult {

    private final int ROUNDING_PLACE = 100;
    private final Map<Prize, Integer> result;

    public LottoResult(Map<Prize, Integer> result) {
        this.result = result;
    }

    public double profitRate() {
        int totalCount = getCountOfTotalTickets();
        int totalPrize = calculateTotalPrize();

        double profitRate = (double) totalPrize / (totalCount * LottoFactory.TICKET_PRICE);

        return Math.floor(profitRate * ROUNDING_PLACE) / ROUNDING_PLACE;
    }

    private int getCountOfTotalTickets() {
        return result.keySet()
                .stream()
                .mapToInt(key -> result.get(key))
                .sum();
    }

    private int calculateTotalPrize() {
        return result.keySet()
                .stream()
                .mapToInt(key -> result.get(key) * key.getPrize())
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return result.equals(that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
