package step3.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String NOT_IN_RANGE = "1~45까지의 숫자를 입력하세요";
    private static Map<Integer, LottoNumber> memorizeNumbers = new HashMap<>();
    private final Integer number;

    static {
        for (int start = MIN_NUMBER; start <= MAX_NUMBER; start++) {
            memorizeNumbers.put(start, new LottoNumber(start));
        }
    }

    private LottoNumber(Integer number) {
        this.number = number;
    }

    public static LottoNumber of(Integer number) {
        LottoNumber beforeNumber = memorizeNumbers.get(number);
        validation(beforeNumber);
        return beforeNumber;
    }

    private static void validation(LottoNumber beforeNumber) {
        if (beforeNumber == null) {
            throw new IllegalArgumentException(NOT_IN_RANGE);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LottoNumber) {
            LottoNumber other = (LottoNumber)obj;
            return this.number.equals(other.number);
        }
        return false;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return (number > other.number) ? 1 : -1;
    }

    public String getStatus() {
        return String.valueOf(number);
    }
}
