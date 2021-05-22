package io.mwkwon.lotto.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LottoPayment {
    public static final int LOTTO_PRICE = 1000;
    public static final String MINIMUM_EXCEPTION_MESSAGE = "최소 로또 구입 가능 금액은 1000원 입니다.";
    public static final String NULL_AND_EMPTY_EXCEPTION_MESSAGE = "로또 구입 금액이 입력 되지 않았습니다.";
    public static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "로또 구입 금액은 숫자만 입력 가능합니다.";
    public static final String REGEX = "[^0-9]";

    private final int value;

    public LottoPayment(int value) {
        checkMinimumLottoPayment(value);
        this.value = value;
    }

    public LottoPayment(String value) {
        checkNullAndEmpty(value);
        checkNumberFormat(value);
        int payment = Integer.parseInt(value);
        checkMinimumLottoPayment(payment);
        this.value = payment;
    }

    private void checkNullAndEmpty(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(NULL_AND_EMPTY_EXCEPTION_MESSAGE);
        }
    }

    private void checkNumberFormat(String value) {
        Matcher matcher = Pattern.compile(REGEX).matcher(value);
        if (matcher.find()) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }


    private void checkMinimumLottoPayment(int value) {
        if (value < LOTTO_PRICE) {
            throw new IllegalArgumentException(MINIMUM_EXCEPTION_MESSAGE);
        }
    }

    public int calcLottoBuyQuantity() {
        return this.value / LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPayment that = (LottoPayment) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
