package lotto.model.lotto;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    private final static String RANGE_ERROR_MESSAGE = "유효한 로또 번호가 아닙니다.";
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;
    private static Map<Integer, LottoNumber> cache = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .boxed()
            .collect(Collectors.toMap(Function.identity(), LottoNumber::new));

    private int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number){

        if (isNotValidRange(number)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }

        return cache.get(number);
    }

    private static boolean isNotValidRange(int inputNumber) {
        return inputNumber < MIN_NUMBER || MAX_NUMBER < inputNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LottoNumber)) {
            return false;
        }
        LottoNumber inputNumber = (LottoNumber) obj;
        return inputNumber.number == number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number - o.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
