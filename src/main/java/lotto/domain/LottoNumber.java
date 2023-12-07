package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final String RANGE_EXCEPTION_NOTICE = "유효하지 않은 범위입니다.";

    private static final Map<Integer, LottoNumber> numbers = new HashMap<>();

    static {
        for (int i = MIN; i <= MAX; i++) {
            numbers.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    private LottoNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(RANGE_EXCEPTION_NOTICE);
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static LottoNumber from(int number) {
        return numbers.values().stream()
                .filter(lottoNumber -> lottoNumber.getNumber() == number)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }
}
