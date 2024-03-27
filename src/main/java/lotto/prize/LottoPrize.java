package lotto.prize;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum LottoPrize {

    NONE(0, 0, false),
    MATCH_3(3, 5_000, false),
    MATCH_4(4, 50_000, false),
    MATCH_5(5, 1_500_000, false),
    MATCH_5_BONUS(5, 3_000_000, true),
    MATCH_6(6, 2_000_000_000, false);

    private final Integer correctNumber;
    private final Integer prize;
    private final boolean isBonus;
    private static final Map<PrizeKey, LottoPrize> cache = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(prize -> cache.put(PrizeKey.of(prize.getCorrectNumber(), prize.getIsBonus()),prize));
    }

    LottoPrize(Integer correctNumber, Integer prize, boolean isBonus) {
        this.correctNumber = correctNumber;
        this.prize = prize;
        this.isBonus = isBonus;
    }

    public static LottoPrize from(int count, boolean isBonus) {
        return cache.getOrDefault(PrizeKey.of(count,isBonus),LottoPrize.NONE);
    }

    public int getTotalPrice(long count) {
        return prize * (int) count;
    }

    public Integer getCorrectNumber(){
        return this.correctNumber;
    }

    public boolean getIsBonus(){
        return this.isBonus;
    }

    public int getPrize(){
        return this.prize;
    }
}
