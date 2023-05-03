package study.lotto.step2.domain;

import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public int number() {
        return number;
    }

    public static LottoNumber of(int number) {
        validateNumber(number);
        return LottoNumberCache.cache[number];
    }

    private static void validateNumber(int number) {
        if(isOutOfRange(number)) {
            throw new IllegalArgumentException("로또 번호는 " + MINIMUM_LOTTO_NUMBER + " 이상 " +
                    MAXIMUM_LOTTO_NUMBER + " 이하의 정수입니다: " + number);
        }
    }

    private static boolean isOutOfRange(int number) {
        return number < MINIMUM_LOTTO_NUMBER || MAXIMUM_LOTTO_NUMBER < number;
    }

    private static class LottoNumberCache {
        private static final LottoNumber[] cache = new LottoNumber[MAXIMUM_LOTTO_NUMBER + 1];

        static {
            IntStream.rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
                    .forEach(number -> cache[number] = new LottoNumber(number));
        }

        private LottoNumberCache() {
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
