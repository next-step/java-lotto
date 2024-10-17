package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNum implements Comparable<LottoNum> {

    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;

    private final int num;

    public LottoNum(String num) {
        this(Integer.parseInt(num));
    }

    public LottoNum(int num) {
        isBoundLottoNumber(num);
        this.num = num;
    }

    public static LottoNum valueOf(int num) {
        isBoundLottoNumber(num);
        return LottoNumCache.cache[num + (-LottoNumCache.low)];
    }

    private static void isBoundLottoNumber(int num) {
        if (num < LOTTO_START_NUMBER || num > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("로또 번호의 범위는 1 ~ 45 여야 합니다.");
        }
    }

    public static List<LottoNum> getLottoNumbers() {
        List<LottoNum> result = new ArrayList<>();
        IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .forEach(num -> result.add(LottoNum.valueOf(num)));
        return result;
    }

    @Override
    public int compareTo(LottoNum lottoNum) {
        return Integer.compare(this.num, lottoNum.num);
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }

    private static class LottoNumCache {
        static int low = LOTTO_START_NUMBER;
        static int high = LOTTO_END_NUMBER;
        static LottoNum[] cache;

        static {
            cache = new LottoNum[(high - low) + 1];
            int num = LOTTO_START_NUMBER;
            for (int i = 0; i < cache.length; i++) {
                cache[i] = new LottoNum(num++);
            }
        }
    }
}
