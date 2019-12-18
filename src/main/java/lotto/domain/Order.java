package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int payment;
    private List<String> lottoNumbers;

    public int getPayment() {
        return payment;
    }

    public List<String> getLottoNumbers() {
        return lottoNumbers;
    }

    private Order(Builder builder) {
        this.payment = builder.payment;
        this.lottoNumbers = builder.lottoNumbers;
    }

    public static class Builder {

        private int payment = 0;
        private List<String> lottoNumbers = new ArrayList<>();

        public Builder() {
        }

        public Builder payment(int payment) {
            this.payment = payment;
            return this;
        }

        public Builder lottNumbers(List<String> lottoNumbers) {
            this.lottoNumbers = lottoNumbers;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
