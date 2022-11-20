package lotto.model;

import java.util.*;
import java.util.stream.Collectors;


public class LottoNumber {
    public static final int LOTTO_END_NUMBER = 45;
    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber lottoNumber(int number) {
        validation(number);
        return CacheLotto.cache.get(number);
    }

    private static void validation(int number) {
        if (number > LOTTO_END_NUMBER || number <= 0) {
            throw new IllegalArgumentException("보너스 볼은 1~45 사이의 숫자입니다");
        }
    }

    public static Set<LottoNumber> winningToSet(Set<String> winningLottos) {
        return winningLottos.stream()
                .map(string -> lottoNumber(Integer.parseInt(string)))
                .collect(Collectors.toSet());
    }

    public static Map<Integer, LottoNumber> cache() {
        return CacheLotto.cache;
    }

    public static Set<LottoNumber> toLottoNumberSet(List<Integer> testLotto) {
        return testLotto.stream()
                .map(Integer -> cache().get(Integer))
                .collect(Collectors.toSet());
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
