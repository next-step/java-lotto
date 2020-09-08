package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoResult {

    private final int ROUNDING_PLACE = 100;
    private final Map<Prize, Integer> prizeResult;

    // 테스트 코드에서 사용
    public LottoResult(Map<Prize, Integer> prizeResult) {
        this.prizeResult = prizeResult;
    }

    public static LottoResult of(Map<Prize, List<LottoNumbers>> prizeResult) {
        return new LottoResult(countByPrize(prizeResult));
    }

    private static Map<Prize, Integer> countByPrize(Map<Prize, List<LottoNumbers>> ticketsPerPrize) {
        return ticketsPerPrize.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
    }

    public int getMatchCountByPrize(Prize prize) {
        return prizeResult.containsKey(prize) ? prizeResult.get(prize) : 0;
    }

    public double profitRate() {
        int totalCount = getCountOfTotalTickets();
        int totalPrize = calculateTotalPrize();

        double profitRate = (double) totalPrize / (totalCount * LottoFactory.TICKET_PRICE);

        return Math.floor(profitRate * ROUNDING_PLACE) / ROUNDING_PLACE;
    }

    private int getCountOfTotalTickets() {
        return prizeResult.keySet()
                .stream()
                .mapToInt(key -> prizeResult.get(key))
                .sum();
    }

    private int calculateTotalPrize() {
        return prizeResult.keySet()
                .stream()
                .mapToInt(key -> prizeResult.get(key) * key.getReward())
                .sum();
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
