package lotto.model;

import lotto.model.enums.Ranking;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Rankings {
    public static final int LOTTO_PRICE = 1000;
    public static final String RANKING_FORMAT = "%d개 일치 (%d원)- %d개";
    public static final String LINE_BREAK = "\n";
    private final Map<Ranking, Integer> rankings;

    public Rankings(final Map<Ranking, Integer> result) {
        this.rankings = Collections.unmodifiableMap(result);
    }

    public double statistics(int buyCount) {
        double buyAmount = Integer.valueOf(buyCount * LOTTO_PRICE)
                .doubleValue();
        double winningAmount = Long.valueOf(rankings.entrySet().stream()
                        .mapToLong(value -> value.getKey().calculate(value.getValue())).sum())
                .doubleValue();
        return winningAmount / buyAmount;
    }

    public String result() {
        return rankings.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(o -> o.getKey().matchedCount()))
                .map(entry -> String.format(RANKING_FORMAT,
                        entry.getKey().matchedCount(),
                        entry.getKey().winningAmount(),
                        entry.getValue()
                ))
                .collect(Collectors.joining(LINE_BREAK));
    }
}
