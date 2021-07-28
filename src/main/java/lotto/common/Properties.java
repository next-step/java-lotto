package lotto.common;

import java.util.HashMap;
import java.util.Map;

public class Properties {

    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final long LOTTO_PRICE = 1000;

    public static final Map<Long, Long> LOTTO_PRIZE_MONEYS = new HashMap<Long, Long>() {{
        put(3L, 5000L);
        put(4L, 50000L);
        put(5L, 1500000L);
        put(6L, 2000000000L);
    }};
}
