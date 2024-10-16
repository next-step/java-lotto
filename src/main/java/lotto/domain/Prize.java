package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Prize {

    FIRST("6개 일치 (2000000000) - ", 6, 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치(30000000원) - ", 5, 30_000_000),
    THIRD("5개 일치 (1500000) - ", 5, 1_500_000),
    FOURTH("4개 일치 (50000원) - ", 4, 50_000),
    FIFTH("3개 일치 (5000원) - ", 3, 5000),
    MISS("", 0, 0);

    private final String message;
    private final int rank;
    private final int price;

    private static final Map<Prize, Integer> map = new HashMap<>();

    static {
        for (Prize prize : values()) {
            map.put(prize, 0);
        }
    }

    Prize(String message, int rank, int price) {
        this.message = message;
        this.rank = rank;
        this.price = price;
    }

    public String getMessage() {
        return message;
    }

    public int getRank() {
        return rank;
    }

    public int getPrice() {
        return price;
    }

    public static Prize valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == 5 && matchBonus) {
            return SECOND;
        }
        if (countOfMatch == 5) {
            return THIRD;
        }
        return Arrays.stream(values())
                .filter(prize -> prize.getRank() == countOfMatch)
                .findFirst()
                .orElse(Prize.MISS);
    }

    public static Map<Prize, Integer> getMap() {
        return map;
    }
}
