package domain;

import java.util.HashMap;
import java.util.Map;

public class Prize {
    public static final int THREE_NUMBERS_PRIZE = 5_000;
    public static final int FOUR_NUMBERS_PRIZE = 50_000;
    public static final int FIVE_NUMBERS_PRIZE = 1_500_000;
    public static final int SIX_NUMBERS_PRIZE = 2_000_000_000;

    public static final Map<Integer, Integer> prizes = new HashMap<Integer, Integer>(){
        {
            put(3, THREE_NUMBERS_PRIZE);
            put(4, FOUR_NUMBERS_PRIZE);
            put(5, FIVE_NUMBERS_PRIZE);
            put(6, SIX_NUMBERS_PRIZE);
        }
    };
}
