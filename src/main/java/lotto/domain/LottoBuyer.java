package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoBuyer {
    public static final int MIN_PURCHASABLE_COUNT = 0;
    private final LottoStore lottoStore;
    private final int payment;

    public LottoBuyer(LottoStore lottoStore, int payment) {
        this.lottoStore = lottoStore;
        this.payment = payment;
    }

    public void validatePurchasable(int count) {
        if (count < MIN_PURCHASABLE_COUNT) {
            throw new IllegalArgumentException();
        }

        if (!lottoStore.purchasable(payment, count)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBuyer that = (LottoBuyer) o;
        return payment == that.payment && Objects.equals(lottoStore, that.lottoStore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoStore, payment);
    }
}
