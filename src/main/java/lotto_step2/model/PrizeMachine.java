package lotto_step2.model;

import java.util.List;

import static lotto_step2.LottoConstants.*;

public enum PrizeMachine {

    FIRST(MATCH_PRIZE_FIRST, 2_000_000_000),
    SECOND(MATCH_PRIZE_SECOND, 1_500_000),
    THIRD(MATCH_PRIZE_THIRD, 50_000),
    FOURTH(MATCH_PRIZE_FOURTH, 5_000),
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

    public int getMatchCount() {
        return this.matchCount;
    }

    public static PrizeMachine matchPrize(int matchCount) {
        for (PrizeMachine prize : PrizeMachine.values()) {
            if (prize.matchCount == matchCount) {
                return prize;
            }
        }
        return PrizeMachine.ZERO;
    }

    public static double calcRevenue(List<PrizeMachine> gameResults, int money) {
        int totalPrize = 0;

        for (PrizeMachine result : gameResults) {
            totalPrize += result.getLottoPrize();
        }
        return (double) totalPrize / money;
    }
}
