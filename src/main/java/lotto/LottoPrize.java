package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum LottoPrize {

    NONE(0,0),
    MATCH_3(3, 5_000),
    MATCH_4(4, 50_000),
    MATCH_5(5, 1_500_000),
    MATCH_6(6, 2_000_000_000);

    private final Integer correctNumber;
    private final Integer prize;
    private static final Map<Integer, LottoPrize> cache = new HashMap<>();

    static {
        Arrays.stream(values()).forEach( lottoPrize -> cache.put(lottoPrize.correctNumber,lottoPrize));
    }

    LottoPrize(Integer correctNumber, Integer prize) {
        this.correctNumber = correctNumber;
        this.prize = prize;
    }

    public static LottoPrize from(int count) {
        if (cache.containsKey(count)) {
            return cache.get(count);
        }
        return LottoPrize.NONE;
    }

    public String formatPrizeText(long count) {
        return String.format("%d개 일치 (%d원)- %d개\n", this.correctNumber, this.prize, count);
    }

    public int getTotalPrice(long count){
        return prize * (int)count;
    }
}
