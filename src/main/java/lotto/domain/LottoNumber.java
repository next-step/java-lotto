package lotto.domain;

import lotto.domain.exception.ErrorMessage;
import lotto.domain.exception.NotValidLottoNumberException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final Map<Integer, LottoNumber> numbers = new HashMap<>();
    public static final int MIN = 1;
    public static final int MAX = 45;

    static {
        IntStream.rangeClosed(MIN, MAX)
                .forEach(i -> numbers.put(i, new LottoNumber(i)));
    }

    private int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        if (numbers.get(number) == null) {
            throw new NotValidLottoNumberException(ErrorMessage.NOT_VALID_LOTTO_NUMBER.getMessage());
        }
        return numbers.get(number);
    }

    public static List<Integer> findAllLottoNumbers() {
        return numbers.entrySet()
                        .stream()
                        .map(i -> i.getValue().number)
                        .collect(Collectors.toList());
    }

    public int getNumber() {
        return number;
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
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }
}
