package util;

import domain.LottoNumber;

import java.util.*;

public class LottoNumberGenerator {

    public static final Integer MIN_LOTTO_NUMBER = Integer.valueOf(1);
    public static final Integer MAX_LOTTO_NUMBER = Integer.valueOf(45);
    public static final Integer LOTTO_NUMBER_COUNT_LIMIT = Integer.valueOf(6);

    private static final Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    static {
        initialize();
    }

    private static void initialize() {
        for (int i = MIN_LOTTO_NUMBER; i < MAX_LOTTO_NUMBER; i++) {
            lottoNumberCache.put(i, new LottoNumber(i));
        }
    }

    public static List<Integer> generateLottoNumber() {
        List<Integer> keys = new ArrayList<>(lottoNumberCache.keySet());
        Collections.shuffle(keys);

        return keys.subList(0, LOTTO_NUMBER_COUNT_LIMIT);
    }

    public static LottoNumber getNumber(int num) {
        return lottoNumberCache.get(num);
    }
}
