package lotto.constant;

import java.util.Map;

public class LottoConstants {
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final Map<Integer, Integer> MATCH_PRICES = Map.of(
            3, 5_000,
            4, 50_000,
            5, 1_500_000,
            6, 2_000_000_000
    );
}
