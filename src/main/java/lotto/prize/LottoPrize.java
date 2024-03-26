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
    private static final Map<String, LottoPrize> cache = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(prize -> cache.put(getKey(prize.correctNumber,prize.isBonus),prize));
    }

    LottoPrize(Integer correctNumber, Integer prize, boolean isBonus) {
        this.correctNumber = correctNumber;
        this.prize = prize;
        this.isBonus = isBonus;
    }

    public static LottoPrize from(int count, boolean isBonus) {
        if (cache.containsKey(getKey(count,isBonus))) {
            return cache.get(getKey(count,isBonus));
        }
        return LottoPrize.NONE;
    }

    public String formatPrizeText(long count) {
        if(this.isBonus){
            return String.format("%d개 일치, 보너스 볼 일치(%d원) - %d개\n",this.correctNumber,this.prize,count);
        }
        return String.format("%d개 일치 (%d원)- %d개\n", this.correctNumber, this.prize, count);
    }

    public int getTotalPrice(long count) {
        return prize * (int) count;
    }

    private static String getKey(int correctNumber, boolean isBonus) {
        return correctNumber + "|" + isBonus;
    }
}
