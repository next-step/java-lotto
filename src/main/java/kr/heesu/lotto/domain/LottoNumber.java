package kr.heesu.lotto.domain;

import kr.heesu.lotto.enums.ExceptionMessage;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_CACHE = new HashMap<>();

    static {
        IntStream.rangeClosed(MIN, MAX)
                .forEach(number -> LOTTO_NUMBER_CACHE.put(number, new LottoNumber(number)));
    }

    private final int lottoNumber;

    private LottoNumber(int number) {
        this.lottoNumber = number;
    }

    public static LottoNumber of(int number) {
        validationCheck(number);
        return LOTTO_NUMBER_CACHE.get(number);
    }

    public static LottoNumber of(String number) {
        int lottoNumber = Integer.parseInt(number);

        validationCheck(lottoNumber);
        return LOTTO_NUMBER_CACHE.get(lottoNumber);
    }

    private static void validationCheck(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_FOR_LOTTO_NUMBER.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LottoNumber) {
            LottoNumber other = (LottoNumber) obj;
            return this.lottoNumber == other.lottoNumber;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
