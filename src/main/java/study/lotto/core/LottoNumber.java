package study.lotto.core;

import study.lotto.core.exception.LottoNumberFormatException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class LottoNumber implements Comparable<LottoNumber>{

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private static final Set<LottoNumber> lottoNumberCache = new HashSet<>();
    private final int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber of(int value) {
        try {
            throwIfOutOfRange(value);
            return  findOrElseAdd(value);
        } catch (Exception e) {
            throw new LottoNumberFormatException(value);
        }
    }

    public static LottoNumber of(String value) {
        return LottoNumber.of(parseToInt(value));
    }

    public static LottoNumber zero() {
        return new LottoNumber(0);
    }

    private static int parseToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new LottoNumberFormatException(value);
        }
    }

    private static void throwIfOutOfRange(int value) {
        if (value < MIN_LOTTO_NUMBER || value > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1 - 45사이의 숫자만 가능합니다.");
        }
    }

    private static LottoNumber findOrElseAdd(int value) {
        Optional<LottoNumber> lottoNumberOptional = findByValue(value);

        if (!lottoNumberOptional.isPresent()) {
            LottoNumber lottoNumber = new LottoNumber(value);
            lottoNumberCache.add(lottoNumber);
            return lottoNumber;
        }

        return lottoNumberOptional.get();
    }

    private static Optional<LottoNumber> findByValue(int value) {
        return lottoNumberCache.stream()
                .filter(lottoNumber -> lottoNumber.equals(value))
                .findFirst();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return value - lottoNumber.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
