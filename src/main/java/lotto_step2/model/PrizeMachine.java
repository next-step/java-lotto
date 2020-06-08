package lotto_step2.model;

import java.util.EnumMap;
import java.util.List;

import static lotto_step2.LottoConstants.*;

public enum PrizeMachine {

    FIRST(MATCH_PRIZE_FIRST, 2_000_000_000),
    SECOND(MATCH_PRIZE_SECOND, 30_000_000),
    THIRD(MATCH_PRIZE_SECOND, 1_500_000),
    FOURTH(MATCH_PRIZE_THIRD, 50_000),
    FIFTH(MATCH_PRIZE_FOURTH, 5_000),
    ZERO(MATCH_ZERO, 0);

    private int matchCount;
    private int prize;

    PrizeMachine(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getLottoPrize() {
        return this.prize;
    }

    public static PrizeMachine matchPrize(int matchCount, boolean isBonus) {
        for (PrizeMachine prize : PrizeMachine.values()) {
            if ((prize.matchCount == SECOND.matchCount) && isBonus) {
                return SECOND;
            } else if (prize.matchCount == matchCount) {
                return calcPrize(prize);
            }
        }
        return PrizeMachine.ZERO;
    }

    private static PrizeMachine calcPrize(PrizeMachine prize) {
        if (prize == SECOND) {
            prize = THIRD;
        }
        return prize;
    }

    public static double calcRevenue(List<PrizeMachine> gameResults, int money) {
        int totalPrize = 0;

        for (PrizeMachine result : gameResults) {
            totalPrize += result.getLottoPrize();
        }
        return (double) totalPrize / money;
    }

    public static EnumMap<PrizeMachine, Integer> calcGameResult(List<PrizeMachine> gameResults) {

        EnumMap<PrizeMachine, Integer> matches = new EnumMap<>(PrizeMachine.class);

        matches.put(FIFTH, (int) gameResults.stream()
                .filter(result -> result == FIFTH)
                .count());

        matches.put(FOURTH, (int) gameResults.stream()
                .filter(result -> result == FOURTH)
                .count());

        matches.put(THIRD, (int) gameResults.stream()
                .filter(result -> result == THIRD)
                .count());

        matches.put(SECOND, (int) gameResults.stream()
                .filter(result -> result == SECOND)
                .count());

        matches.put(FIRST, (int) gameResults.stream()
                .filter(result -> result == FIRST)
                .count());

        return matches;
    }
}
