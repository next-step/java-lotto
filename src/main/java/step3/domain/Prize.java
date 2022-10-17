package step3.domain;

import java.util.Arrays;
import java.util.Map;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int reward;
    private static final int MINIMUM_PRIZE_RANGE = 3;
    private static final int MAXIMUM_PRIZE_RANGE = 6;

    Prize(int countOfMatch, int reward){
        this.countOfMatch = countOfMatch;
        this.reward = reward;
    }

    public static int calculateTotalIncome(final Map<Prize, Integer> drawLottoResult){
        int totalReward = 0;
        for (Prize prize: drawLottoResult.keySet()) {
            totalReward += prize.getReward() * drawLottoResult.get(prize);
        }
        return totalReward;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getReward() {
        return reward;
    }

    public static Prize getPrize(int matchCount) {
        if (matchCount > MAXIMUM_PRIZE_RANGE) {
            throw new IllegalArgumentException("6개 이상 당첨될 수 없습니다.");
        }

        if (matchCount < MINIMUM_PRIZE_RANGE) {
            return Prize.MISS;
        }

        return Arrays.stream(Prize.values())
            .filter(prize -> prize.getCountOfMatch() == matchCount)
            .findAny()
            .get();
    }
}
