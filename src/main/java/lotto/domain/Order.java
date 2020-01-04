package lotto.domain;

import lotto.exception.LottoServiceException;

import java.util.ArrayList;
import java.util.List;


public class Order {

    private int payment;
    private List<String> selfNumbers;

    private Order(Builder builder) {
        this.payment = builder.payment;
        this.selfNumbers = builder.selfNumbers;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getAutoNumberCount() {
        return payment / LottoPolicy.LOTTO_PRICE - selfNumbers.size();
    }

    public int getSelfNumberCount() {
        return selfNumbers.size();
    }

    public int getPayment() {
        return payment;
    }

    List<String> getSelfNumbers() {
        return selfNumbers;
    }

    public static class Builder {

        private int payment = 0;
        private List<String> selfNumbers = new ArrayList<>();

        Builder() {
        }

        public Builder payment(int payment) {
            validatePayment(payment);
            this.payment = payment;
            return this;
        }

        public Builder selfNumber(List<String> selfNumber) {
            validateSelfNumberCount(selfNumber);
            this.selfNumbers = selfNumber;
            return this;
        }

        private void validatePayment(int payment) {
            if (payment < LottoPolicy.LOTTO_PRICE)
                throw new LottoServiceException(LottoError.MINIMUM_PAYMENT);
        }

        private void validateSelfNumberCount(List<String> selfNumbers) {
            if (selfNumbers.size() > this.payment / LottoPolicy.LOTTO_PRICE)
                throw new LottoServiceException(LottoError.SELF_NUMBER_CANNOT_EXCEED_THE_COUNT);
        }

        public Order build() {
            return new Order(this);
        }
    }
}
