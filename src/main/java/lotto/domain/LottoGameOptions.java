package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoGameOptions {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;

    public static final int LOTTO_NUMBERS_FROM = 1;
    public static final int LOTTO_NUMBERS_TO = 45;

    public static final Map<Integer, LottoResult> MAP_LOTTO_RESULT;
    static {
        Map<Integer, LottoResult> mapLottoResult = new HashMap<>();
        mapLottoResult.put(0, LottoResult.MATCH_0);
        mapLottoResult.put(1, LottoResult.MATCH_1);
        mapLottoResult.put(2, LottoResult.MATCH_2);
        mapLottoResult.put(3, LottoResult.MATCH_3);
        mapLottoResult.put(4, LottoResult.MATCH_4);
        mapLottoResult.put(5, LottoResult.MATCH_5);
        mapLottoResult.put(6, LottoResult.MATCH_6);
        MAP_LOTTO_RESULT = Collections.unmodifiableMap(mapLottoResult);
    }
}
