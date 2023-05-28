package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Prize {
    FIRST_PRIZE(6, false, 2_000_000_000),

    SECOND_PRIZE(5, true, 300_000_000),

    THIRD_PRIZE(5, false, 1_500_000),

    FOURTH_PRIZE(4, false, 50_000),

    FIFTH_PRIZE(3, false, 5_000),

    NOT_MATCHING(0, false, 0);

    private final Integer numberOfMatching;
    private final Boolean bonusMatching;
    private final Long prize;

    Prize(int numberOfMatching, boolean bonusMatching, long prize) {
        this.numberOfMatching = numberOfMatching;
        this.bonusMatching = bonusMatching;
        this.prize = prize;
    }

    public int numberOfMatching() {
        return numberOfMatching;
    }

    public static Prize create(int numberOfMatching, boolean bonusMatching) {
        return Arrays.stream(Prize.values())
                .filter(p -> p.numberOfMatching == numberOfMatching && p.bonusMatching == bonusMatching)
                .findFirst()
                .orElse(NOT_MATCHING);
    }

    public static Map<Prize, Integer> winningStatus(List<Prize> prizeTypesOfTickets) {
        Map<Prize, Integer> map = new HashMap<>();
        Arrays.stream(Prize.values())
                .forEach(prizeType -> map.put(prizeType, countPrizeType(prizeTypesOfTickets, prizeType)));
        return map;
    }

    private static int countPrizeType(List<Prize> prizeTypesOfTickets, Prize prize) {
        return (int) prizeTypesOfTickets.stream()
                .filter(t -> t == prize)
                .count();
    }

    public long prize() {
        return prize;
    }
}