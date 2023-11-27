package domain;


import java.util.HashMap;
import java.util.Map;

public class LottoPrize implements Prize {

    public static final Map<Integer, Integer> PRIZE_MAP = new HashMap<>();

    static {
        PRIZE_MAP.put(3, 5_000);
        PRIZE_MAP.put(4, 50_000);
        PRIZE_MAP.put(5, 1_500_000);
        PRIZE_MAP.put(6, 2_000_000_000);
    }
    private final int value;

    private final int lottoWinNumbers;

    public LottoPrize(int value) {
        this.value = value;
        this.lottoWinNumbers = PRIZE_MAP.get(value);
    }

    @Override
    public Prize winLotto(final Lotto lotto) {
        return null;
    }
}
