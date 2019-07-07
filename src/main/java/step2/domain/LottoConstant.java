package step2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoConstant {
    public static final Map<Integer, LottoNumber> LOTTO_NUMBERS_MAP = new HashMap<>();
    public static final List<Map.Entry<Integer, LottoNumber>> LOTTO_NUMBERS_ENTRY;
    public static final Integer LOTTO_MIN_NUMBER = 1;
    public static final Integer LOTTO_MAX_NUMBER = 49;
    public static final Integer LOTTO_NUMBER_SIZE = 6;

    static {
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            LOTTO_NUMBERS_MAP.put(i, LottoNumber.create(i));
        }
        LOTTO_NUMBERS_ENTRY = new ArrayList<>(LOTTO_NUMBERS_MAP.entrySet());
    }

    private LottoConstant() {}
}
