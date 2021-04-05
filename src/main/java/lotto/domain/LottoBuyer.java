package lotto.domain;

import java.util.Objects;

public class LottoBuyer {
    private static final int MIN_PURCHASABLE_COUNT = 0;
    private static final String PURCHASABLE_ONE_ERROR_MESSAGE = "구입 금액(payment)는 LottoStore의 가격(price)보다 크거나 같아야 합니다.";

    private final LottoStore lottoStore;
    private final int payment;

    public LottoBuyer(LottoStore lottoStore, int payment) {
        validatePurchasableOne(lottoStore, payment);

        this.lottoStore = lottoStore;
        this.payment = payment;
    }

    private void validatePurchasableOne(LottoStore lottoStore, int payment) {
        if (!lottoStore.purchasable(payment, 1)) {
            throw new IllegalArgumentException(PURCHASABLE_ONE_ERROR_MESSAGE);
        }
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
