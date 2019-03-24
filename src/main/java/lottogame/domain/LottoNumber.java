package lottogame.domain;

import lottogame.validator.LottoNumberValidator;
import lottogame.validator.Validatable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;

    private static final Validatable<Integer> validator = new LottoNumberValidator();
    private static final Map<Integer,LottoNumber> numberPool  = new HashMap<>();

    private final int number;

    private LottoNumber(int number) {
        validator.validate(number);
        this.number = number;
    }

    public static LottoNumber getInstance(int number) {
        validator.validate(number);

        if(!numberPool.containsKey(number)) {
            numberPool.put(number, new LottoNumber(number));
        }

        return numberPool.get(number);
    }

    public int getNumber() {
        return number;
    }

    public boolean equalsNumber(int number) {
        return this.number == number;
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
        return String.valueOf(number);
    }
}