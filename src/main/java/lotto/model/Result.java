package lotto.model;

import lotto.model.enums.Ranking;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.model.enums.Ranking.NONE;
import static lotto.model.enums.Ranking.values;

public class Result {
    public static final int LOTTO_PRICE = 1000;
    public static final String RANKING_FORMAT = "%d개 일치 (%d원)- %d개";
    public static final String LINE_BREAK = "\n";
    private final Buyer buyer;
    private final Lotto winningLotto;

    private Result(Buyer buyer, Lotto winningLotto) {
        this.buyer = buyer;
        this.winningLotto = winningLotto;
    }

    public static Result of(Buyer buyer, Lotto winningLotto) {
        return new Result(buyer, winningLotto);
    }

    public double statistics(int buyCount) {
        double winningAmount = Long.valueOf(rankings()
                        .entrySet()
                        .stream()
                        .mapToLong(value -> value.getKey().totalWinningAmount(value.getValue()))
                        .sum())
                .doubleValue();
        double buyAmount = Integer.valueOf(buyCount * LOTTO_PRICE)
                .doubleValue();
        return winningAmount / buyAmount;
    }

    public String formattedRankingResults() {
        return rankings().entrySet()
                .stream()
                .sorted(Comparator.comparingInt(o -> o.getKey().matchedCount()))
                .map(Result::formattedRankingResult)
                .collect(Collectors.joining(LINE_BREAK));
    }

    public Map<Ranking, Integer> rankings() {
        Map<Ranking, Integer> rankings = new HashMap<>();
        Arrays.stream(values())
                .filter(ranking -> !ranking.equals(NONE))
                .forEach(ranking -> rankings.put(ranking, rankingCount(winningLotto, ranking)));
        return rankings;
    }

    private static String formattedRankingResult(Map.Entry<Ranking, Integer> entry) {
        return String.format(RANKING_FORMAT,
                entry.getKey().matchedCount(),
                entry.getKey().winningAmount(),
                entry.getValue()
        );
    }

    private int rankingCount(Lotto winningLotto, Ranking fourth) {
        long count = this.buyer.value()
                .stream()
                .map(lotto -> lotto.compare(winningLotto))
                .filter(fourth::equals)
                .count();
        return Long.valueOf(count)
                .intValue();
    }
}
