package lotto.number;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    public static final int MIN = 1;
    public static final int MAX = 45;

    private static final IllegalArgumentException NUMBER_SIZE_EXCEPTION
            = new IllegalArgumentException("the lotto number is must between " + MIN + " and " + MAX);
    private static final IllegalArgumentException NOT_NUMBER_DATA_EXCEPTION
            = new IllegalArgumentException("the data is must be numberic data");
    private static Map<Integer, LottoNumber> LOTTO_NUMBER_POOL = new HashMap<>();

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(String numberString) {
        if (isNotNumberData(numberString)) {
            throw NOT_NUMBER_DATA_EXCEPTION;
        }

        int number = Integer.parseInt(numberString.trim());

        return of(number);
    }

    public static LottoNumber of(int number) {
        if (isNotBetweenMinAndMax(number)) {
            throw NUMBER_SIZE_EXCEPTION;
        }

        LOTTO_NUMBER_POOL.putIfAbsent(number, new LottoNumber(number));

        return LOTTO_NUMBER_POOL.get(number);
    }

    public int get() {
        return this.number;
    }

    private static boolean isNotBetweenMinAndMax(int number) {
        return number < MIN || MAX < number;
    }

    private static boolean isNotNumberData(String number) {
        try {
            Integer.parseInt(number);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LottoNumber))
            return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
