package study.lotto.step2.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();
    private final int number;

    static {
        IntStream.rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
                .forEach(lottoNumber -> lottoNumberCache.put(lottoNumber, new LottoNumber(lottoNumber)));
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(String number) {
        validateNumber(number);
        return of(Integer.parseInt(number));
    }

    public static LottoNumber of(int number) {
        validateNumber(number);
        return lottoNumberCache.get(number);
    }

    private int number() {
        return number;
    }

    private static void validateNumber(String number) {
        if(!isPositiveInteger(number)) {
            throw new IllegalArgumentException("로또 번호는 양의 정수입니다: " + number);
        }
    }

    private static boolean isPositiveInteger(String number) {
        return number.matches(POSITIVE_INTEGER_REGEX);
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

    @Override
    public int compareTo(LottoNumber o) {
        return number() - o.number();
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

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
