package lotto.constant;

import java.util.LinkedHashMap;
import java.util.Map;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

    private final static Map<Integer, Prize> PRIZES;

    private final int match;
    private final int prize;

    static {
        PRIZES = new LinkedHashMap<>();
        for (Prize prize : values()) {
            PRIZES.put(prize.match, prize);
        }
    }

    Prize(int match, int prize) {
        this.match = match;
        this.prize = prize;
    }

    public static Prize getPrize(int match) {
        return PRIZES.get(match);
    }

    public int getMatch() {
        return match;
    }

    public int getPrize() {
        return prize;
    }
}
