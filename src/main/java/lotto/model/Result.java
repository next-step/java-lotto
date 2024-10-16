package lotto.model;

import lotto.model.dto.LottoNumber;
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
    public static final String RANKING_FORMAT = "%d개 일치%s(%d원)- %d개";
    public static final String LINE_BREAK = "\n";
    public static final String BONUS_MATCHED_STRINGS = ", 보너스 볼 일치";
    public static final String SPACE = " ";
    private final Buyer buyer;
    private final Winning winning;

    private Result(Buyer buyer, Winning winning) {
        this.buyer = buyer;
        this.winning = winning;
    }


    public static Result of(Buyer buyer, Winning winning) {
        return new Result(buyer, winning);
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
                .sorted(Comparator.comparingLong(ranking -> ranking.getKey().winningAmount()))
                .map(Result::formattedRankingResult)
                .collect(Collectors.joining(LINE_BREAK));
    }

    public Map<Ranking, Integer> rankings() {
        Map<Ranking, Integer> rankings = new HashMap<>();
        Arrays.stream(values())
                .filter(ranking -> !ranking.equals(NONE))
                .forEach(ranking -> rankings.put(ranking, rankingCount(ranking)));
        return rankings;
    }

    private static String formattedRankingResult(Map.Entry<Ranking, Integer> entry) {
        String bonus = SPACE;
        if (entry.getKey().equals(Ranking.SECOND)) {
            bonus = BONUS_MATCHED_STRINGS;
        }
        return String.format(RANKING_FORMAT,
                entry.getKey().matchedCount(),
                bonus,
                entry.getKey().winningAmount(),
                entry.getValue()
        );
    }

    private int rankingCount(Ranking fourth) {
        long count = this.buyer.value()
                .stream()
                .map(lotto -> lotto.compare(winning))
                .filter(fourth::equals)
                .count();
        return Long.valueOf(count)
                .intValue();
    }
}
