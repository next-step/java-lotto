package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.constant.LottoConstants;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LottoNumber implements Comparable<LottoNumber> {
    private static final String NUMBER_BOUND_ERROR_MESSAGE = LottoConstants.MIN_LOTTO_NUMBER + "에서 "
            + LottoConstants.MAX_LOTTO_NUMBER +"사이의 값만 입력 가능합니다.";
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자만 입력 가능 합니다.";
    private static final String REGEX = "[^0-9]";

    private final int number;

    public LottoNumber(int number) {
        validateLottoNumberBound(number);
        this.number = number;
    }

    public LottoNumber(final String strNumber) {
        String trimStrNumber = strNumber.trim();
        checkValidStringNumber(trimStrNumber);
        int number = Integer.parseInt(trimStrNumber);
        validateLottoNumberBound(number);
        this.number = number;
    }

    public static LottoNumber create(String strNumber) {
        return new LottoNumber(strNumber);
    }

    private void checkValidStringNumber(String strNumber) {
        Matcher matcher = Pattern.compile(REGEX).matcher(strNumber);
        if (matcher.find()) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    private void validateLottoNumberBound(final int number) {
        if (number < LottoConstants.MIN_LOTTO_NUMBER || number > LottoConstants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(NUMBER_BOUND_ERROR_MESSAGE);
        }
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

    @Override
    public int compareTo(LottoNumber other) {
        return this.number - other.number;
    }
}
