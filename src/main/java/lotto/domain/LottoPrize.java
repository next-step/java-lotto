package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lotto.domain.Lotto.LOTTO_PRICE;
import static lotto.domain.Lotto.matchCount;

public enum LottoPrize {
    MATCH_3(3, 5000),
    MATCH_4(4, 50000),
    MATCH_5(5, 1500000),
    MATCH_6(6, 2000000000);

    private final int matchCount;
    private final int prizeAmount;

    LottoPrize(int matchCount, int prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static int calculatePrize(int matchCount) {
        return Arrays.stream(values())
                .filter(lottoPrize -> lottoPrize.getMatchCount() == matchCount)
                .findFirst()
                .map(LottoPrize::getPrizeAmount)
                .orElse(0);
    }

    public static Map<Integer, Integer> calculatePrizeCounts(List<Integer> winningNumbers, List<List<Integer>> purchasedTickets) {
        return purchasedTickets.stream()
                .map(ticket -> matchCount(winningNumbers, ticket))
                .filter(matchCount -> matchCount >= 3)
                .collect(Collectors.toMap(Function.identity(), count -> 1, Integer::sum));
    }

    public static double calculateReturnRate(List<Integer> winningNumbers, List<List<Integer>> purchasedTickets) {
        int totalWinnings = purchasedTickets.stream()
                .mapToInt(ticket -> calculatePrize(matchCount(winningNumbers, ticket)))
                .sum();
        int totalInvestment = purchasedTickets.size() * LOTTO_PRICE;

        return (double) totalWinnings / totalInvestment;
    }
}

