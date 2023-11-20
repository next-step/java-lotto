package lotto.domain;

import java.util.*;

public class LottoNumberCache {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private static final Map<Integer, LottoNumber> cacheList = new HashMap<>();

    static {
        for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
            cacheList.put(number, new LottoNumber(number));
        }
    }

    public static LottoNumber findNumber(int number) {
        return cacheList.get(number);
    }

    public static List<LottoNumber> findNumbers() {
        List<LottoNumber> result = new ArrayList<>();

        for (int number : cacheList.keySet()) {
            result.add(cacheList.get(number));
        }

        return result;
    }

    public static Map<Integer, LottoNumber> values() {
        return Collections.unmodifiableMap(cacheList);
    }
}
