package lotto.model;

import java.util.*;
import java.util.stream.Collectors;


public class LottoNumber {
    public static final int LOTTO_END_NUMBER = 45;
    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber cacheLottoNumber(int number) {
        return CacheLotto.cache.get(number);
    }

    public static Set<LottoNumber> lottoNumberSet(int... number) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int num : number) {
            lottoNumbers.add(cacheLottoNumber(num));
        }
        return lottoNumbers;
    }

    public static Map<Integer, LottoNumber> cache() {
        return CacheLotto.cache;
    }

    public static Set<LottoNumber> toLottoNumberSet(List<Integer> testLotto) {
        return testLotto.stream()
                .map(Integer -> cache().get(Integer))
                .collect(Collectors.toSet());
    }

    public static boolean isContain(int element) {
        return cache().containsKey(element);
    }

    public static Set<Integer> elements() {
        return cache().keySet();
    }

    private static class CacheLotto {
        private static final Map<Integer, LottoNumber> cache = new HashMap<>();

        static {
            for (int i = 0; i < LOTTO_END_NUMBER; i++) {
                cache.put(i + 1, new LottoNumber(i + 1));
            }
        }
    }

    boolean isMatchNumber(LottoNumber winNums) {
        return winNums.number == this.number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
