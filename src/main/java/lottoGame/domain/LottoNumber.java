package lottoGame.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    private static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    private int number;

    static {
        IntStream.range(MIN_NUMBER, MAX_NUMBER).forEach(x -> lottoNumbers.put(x, new LottoNumber(x)));
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("1~45 범위 값만 가능합니다.");
        }
        return lottoNumbers.get(number);
    }

    public static Map<Integer, LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return "" +
                number +
                "";
    }

    @Override
    public int compareTo(LottoNumber o) {
        Integer a = number;
        Integer b = o.number;
        return a.compareTo(b);
    }
}
