package lotto.model;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final LottoNumber[] cacheNumber;
    private static final String INVALID_NUMBER_MESSAGE = String.format("로또 번호는 %d ~ %d 사이 숫자만 생성 가능합니다", MIN_NUMBER, MAX_NUMBER);
    private final int number;

    static {
        cacheNumber = new LottoNumber[MAX_NUMBER + 1];
        for (int i = 0; i < MAX_NUMBER + 1; i++) {
            cacheNumber[i] = new LottoNumber(i);
        }
    }

    public LottoNumber(int number) {
        if (!isVaildNumber(number)) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
        this.number = number;
    }

    public static LottoNumber valueOf(int number) {
        if (isVaildNumber(number)) {
            return cacheNumber[number];
        }

        return new LottoNumber(number);
    }

    private static boolean isVaildNumber(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    public int getValue() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber1 = (LottoNumber) o;
        return number == lottoNumber1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
