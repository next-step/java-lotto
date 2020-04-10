package lotto.domain;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MAXIMUM_LOTTO_NUMBER = 45;
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final String LOTTO_VALID_RANGE = "로또는 1과 45사이의 숫자만 가능합니다.";

    private final int number;

    public LottoNumber(final int number) {
        this.number = validate(number);
    }

    private int validate(int number) {
        if (number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_VALID_RANGE);
        }
        return number;
    }

    private static boolean isNumberRange(int number) {
        return number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER;
    }

    public static LottoNumber of(int lottoNumber) {
        if (isNumberRange(lottoNumber)) {
            throw new IllegalArgumentException(LOTTO_VALID_RANGE);
        }

        return lottoNumberFactory.get(lottoNumber);
    }

    private static final Map<Integer, LottoNumber> lottoNumberFactory =
            IntStream.rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
                    .mapToObj(LottoNumber::new)
                    .collect(Collectors.toMap(LottoNumber::getNumber, x -> x));

    public int getNumber() {
        return number;
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

    @Override
    public int compareTo(LottoNumber l) {
        return this.number - l.number;
    }
}
