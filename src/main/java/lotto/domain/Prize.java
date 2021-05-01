package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Prize {

    ZERO(new Hit(0, false), 0, "꽝"),
    THREE(new Hit(3, false), 5_000, "3개 일치 (5000원)"),
    FOUR(new Hit(4, false), 50_000, "4개 일치 (50000원)"),
    FIVE(new Hit(5, false), 1_500_000, "5개 일치 (15000000원)"),
    BONUS(new Hit(5, true), 30_000_000, "5개 일치, 보너스 볼 일치(30000000원)"),
    SIX(new Hit(6, false), 2_000_000_000, "6개 일치 (2000000000원)");

    private final Hit hit;
    private final int reward;
    private final String message;

    Prize(Hit hit, int reward, String message) {
        this.hit = hit;
        this.reward = reward;
        this.message = message;
    }

    public static Prize of(Hit result) {
        if (result.getWinningCount() == BONUS.hit.getWinningCount() && result.isBonus()) return BONUS;
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.hit.getWinningCount() == result.getWinningCount())
                .findAny()
                .orElseGet(() -> Prize.ZERO);
    }

    public static List<Prize> prizeList() {
        return Arrays.asList(Prize.THREE, Prize.FOUR, Prize.FIVE, Prize.BONUS, Prize.SIX);
    }

    public String getMessage() {
        return message;
    }

    public int getReward() {
        return reward;
    }
}
