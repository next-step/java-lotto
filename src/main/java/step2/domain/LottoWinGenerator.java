package step2.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoWinGenerator implements WinGenerator<Lotto> {

    public static final Map<Integer, Integer> PRIZE_MAP = new HashMap<>();

    static {
        PRIZE_MAP.put(0, 0);
        PRIZE_MAP.put(1, 0);
        PRIZE_MAP.put(2, 0);
        PRIZE_MAP.put(3, 5_000);
        PRIZE_MAP.put(4, 50_000);
        PRIZE_MAP.put(5, 1_500_000);
        PRIZE_MAP.put(6, 2_000_000_000);
    }

    @Override
    public Prize winPrize(Lotto lotto) {
        return null;
    }
}
