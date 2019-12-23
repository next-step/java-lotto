package lotto.domain;

import lotto.common.exception.LottoServiceException;

import java.util.ArrayList;
import java.util.List;


public class Order {

    private int payment;
    private List<String> selfNumbers;

    private Order(Builder builder) {

        validatePayment(builder.payment);
        validateSelfNumberCount(builder);

        this.payment = builder.payment;
        this.selfNumbers = builder.selfNumbers;
    }

    private void validateSelfNumberCount(Builder builder) {
        if (builder.selfNumbers.size() > builder.payment / LottoPolicy.LOTTO_PRICE)
            throw new LottoServiceException(LottoError.SELF_NUMBER_CANNOT_EXCEED_THE_COUNT);
    }

    private void validatePayment(int payment) {
        if (payment < LottoPolicy.LOTTO_PRICE)
            throw new LottoServiceException(LottoError.MINIMUM_PAYMENT);
    }

    int getPayment() {
        return payment;
    }

    List<String> getSelfNumbers() {
        return selfNumbers;
    }

    public static class Builder {

        private int payment = 0;
        private List<String> selfNumbers = new ArrayList<>();

        public Builder() {
        }

        public Builder payment(int payment) {
            this.payment = payment;
            return this;
        }

        public Builder selfNumber(List<String> selfNumber) {
            this.selfNumbers = selfNumber;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
