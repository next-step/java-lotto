package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    public static final int START_LOTTO_NUMBER = 1;
    public static final int END_LOTTO_NUMBER = 45;
    private static final String NOT_NUMBER_STRING_NOT_ALLOW_MESSAGE = "숫자가 아닌 문자열은 허용되지 않습니다.";
    private static final String INVALID_NUMBER_MESSAGE = "유효하지 않은 숫자입니다.";

    private final int lottoNumber;

    public LottoNumber(String string) {
        this(toInt(string));
    }

    LottoNumber(int lottoNumber) {
        checkInvalid(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private static int toInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_STRING_NOT_ALLOW_MESSAGE);
        }
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }

    private void checkInvalid(int lottoNumber) {
        if (lottoNumber < START_LOTTO_NUMBER || lottoNumber > END_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
