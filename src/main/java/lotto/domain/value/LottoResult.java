package lotto.domain.value;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private static final int BASIC_UNIT = 1000;

    private final Map<Rank, Integer> result;
    private final int numberOfTickets;

    private LottoResult(Map<Rank, Integer> result, int numberOfTickets) {
        this.result = new EnumMap<>(result);
        this.numberOfTickets = numberOfTickets;
    }

    public static LottoResult of(Map<Rank, Integer> result, int numberOfTickets) {
        return new LottoResult(result, numberOfTickets);
    }

    public double getProfitRate() {
        return calculateProfitRate();
    }

    public Map<Rank, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }

    private double calculateProfitRate() {
        Integer profit = result.keySet()
                .stream()
                .map(Rank::getPrizeMoney)
                .reduce(0, Integer::sum);

        return formula(profit);
    }

    private double formula(int afterMoney) {
        return (double) afterMoney / (numberOfTickets * BASIC_UNIT);
    }
}
