package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class LottoNumber {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final String INCORRECT_RANGE_ERROR = "로또번호는 " + MIN_VALUE + "~" + MAX_VALUE + "사이의 값만 가능합니다.";
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();
    private static final Random RANDOM = new Random();

    static {
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    private LottoNumber(final int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(final int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException(INCORRECT_RANGE_ERROR);
        }
    }

    public static LottoNumber generateRandomNumber() {
        return from(RANDOM.nextInt(MAX_VALUE) + MIN_VALUE);
    }

    public static LottoNumber from(int number) {
        LottoNumber lottoNumber = lottoNumbers.get(number);
        if (lottoNumber == null) {
            throw new IllegalArgumentException(INCORRECT_RANGE_ERROR);
        }
        return lottoNumber;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) object;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    public int getNumber() {
        return number;
    }
}
