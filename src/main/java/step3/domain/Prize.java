package step3.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.BiFunction;

public enum Prize {

    FIRST(6, 2_000_000_000, (countOfMatch, isMatchBonus) -> countOfMatch == 6),
    SECOND(5, 30_000_000, (countOfMatch, isMatchBonus) -> countOfMatch == 5 && isMatchBonus),
    THIRD(5, 1_500_000, (countOfMatch, isMatchBonus) -> countOfMatch == 5 && !isMatchBonus),
    FOURTH(4, 50_000, (countOfMatch, isMatchBonus) -> countOfMatch == 4),
    FIFTH(3, 5_000, (countOfMatch, isMatchBonus) -> countOfMatch == 3),
    MISS(0, 0, (countOfMatch, isMatchBonus) -> countOfMatch < 3);

    private final int countOfMatch;
    private final int reward;
    private static final int MAXIMUM_PRIZE_RANGE = 6;
    private final BiFunction<Integer, Boolean, Boolean> biFunction;

    Prize(int countOfMatch, int reward, BiFunction<Integer, Boolean, Boolean> biFunction){
        this.countOfMatch = countOfMatch;
        this.reward = reward;
        this.biFunction = biFunction;
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

    public static Prize valueOf(int countOfMatch, boolean isMatchBonus) {
        if (countOfMatch > MAXIMUM_PRIZE_RANGE) {
            throw new IllegalArgumentException("6개 이상 당첨될 수 없습니다.");
        }

        return Arrays.stream(Prize.values())
            .filter(prize -> prize.biFunction.apply(countOfMatch, isMatchBonus))
            .findFirst()
            .get();
    }
}
