package lottoauto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static final Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    static {
        // 1 ~ 45 각 숫자별 LottoNumber 맵핑
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER).forEach(i -> lottoNumberCache.put(i, new LottoNumber(i)));
    }

    private int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        return lottoNumberCache.get(number);
    }

    public static LottoNumber from(String number) {
        return lottoNumberCache.get(Integer.parseInt(number));
    }

    public static IntStream rangedClosed() {
        return IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
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

    @Override
    public String toString() {
//        return "LottoNumber{" +
//                "number=" + number +
//                '}';
        return "" + number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        if(this.number < o.number) {
            return -1;
        }
        if(this.number == o.number) {
            return 0;
        }
        return 1;
    }
}
