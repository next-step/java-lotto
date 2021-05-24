package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.constant.LottoConstants;
import io.mwkwon.lotto.interfaces.InputView;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LottoPayment {
    private static final String MINIMUM_EXCEPTION_MESSAGE = "최소 로또 구입 가능 금액은 " + LottoConstants.LOTTO_PRICE + "원 입니다.";
    private static final String NULL_AND_EMPTY_EXCEPTION_MESSAGE = "로또 구입 금액이 입력 되지 않았습니다.";
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "로또 구입 금액은 숫자만 입력 가능합니다.";
    private static final String REGEX = "[^0-9]";

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

    public static LottoPayment create(InputView inputView) {
        LottoPayment lottoPayment = null;
        try {
            String value = inputView.requestInputPayment(LottoConstants.REQUEST_PAYMENT_MESSAGE);
            lottoPayment = new LottoPayment(value);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + LottoConstants.RETRY_MESSAGE);
            create(inputView);
        }
        return lottoPayment;
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
        if (value < LottoConstants.LOTTO_PRICE) {
            throw new IllegalArgumentException(MINIMUM_EXCEPTION_MESSAGE);
        }
    }

    public int calcLottoBuyQuantity() {
        return this.value / LottoConstants.LOTTO_PRICE;
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
}
