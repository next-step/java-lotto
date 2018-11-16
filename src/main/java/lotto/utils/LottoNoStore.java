package lotto.utils;

import lotto.domain.LottoNo;

import java.util.HashMap;
import java.util.Map;

public class LottoNoStore {

    private static final Map<Integer, LottoNo> LOTTO_NO_MAP = new HashMap<>();

    private LottoNoStore() {

    }

    public static LottoNo get(int key) {
        return LOTTO_NO_MAP.get(Integer.valueOf(key));
    }

    public static LottoNo put(int key, LottoNo lottoNo) {
        LOTTO_NO_MAP.put(Integer.valueOf(key), lottoNo);
        return LOTTO_NO_MAP.getOrDefault(key, lottoNo);
    }

    public static boolean exists(int key) {
        return LOTTO_NO_MAP.containsKey(Integer.valueOf(key));
    }
}
