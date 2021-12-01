package domain;

import static controller.LottoGame.*;

public enum Prize {

    FIRST(FIRST_PRIZE_MATCHING_NUMBER, FIRST_PRIZE_REWARD, INITIAL_PRIZE_COUNT),
    THIRD(THIRD_PRIZE_MATCHING_NUMBER, THIRD_PRIZE_REWARD, INITIAL_PRIZE_COUNT),
    FOURTH(FOURTH_PRIZE_MATCHING_NUMBER, FOURTH_PRIZE_REWARD, INITIAL_PRIZE_COUNT),
    FIFTH(FIFTH_PRIZE_MATCHING_NUMBER, FIFTH_PRIZE_REWARD, INITIAL_PRIZE_COUNT);

    private final int matchingNumber;
    private final int reward;
    private int count;

    Prize(int matchingNumber, int reward, int count) {
        this.matchingNumber = matchingNumber;
        this.reward = reward;
        this.count = count;
    }

    public int getMatchingNumber() {
        return matchingNumber;
    }

    public int getReward() {
        return reward;
    }

    public int getCount() {
        return count;
    }

    public int profit() {
        return count * reward;
    }

    public static int sumProfit() {
        int profit = 0;

        for (Prize prize : values()) {
            profit += prize.profit();
        }

        return profit;
    }

    public static void countPrize(int matchingNumber) {
        for (Prize prize : Prize.values()) {
            compareValueOfPrize(prize, matchingNumber);
        }
    }

    public static void resetPrize() {
        for (Prize prize : Prize.values()) {
            prize.count = INITIAL_PRIZE_COUNT;
        }
    }

    private static void compareValueOfPrize(Prize prize, int matchingNumber) {
        if (prize.matchingNumber == matchingNumber) {
            prize.count++;
        }
    }
}
