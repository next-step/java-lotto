package lotto.domain;

import java.text.MessageFormat;

public class LottoPurchase {
    private static final int LOTTO_PRICE = 1_000;
    private final Payment payment;
    private final int manualCount;

    public LottoPurchase(int paymentValue, int manualCountValue) {
        validate(paymentValue, manualCountValue);
        this.payment = new Payment(paymentValue);
        this.manualCount = manualCountValue;
    }

    private void validate(int paymentValue, int manualCountValue) {
        if (paymentValue < manualCountValue * LOTTO_PRICE) {
            throw new IllegalArgumentException(
                    MessageFormat.format("금액이 부족합니다. 현재 금액 : {0}원", paymentValue)
            );
        }
    }

    public Payment getPayment() {
        return payment;
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutomaticCount() {
        return payment.subtractFrom(manualCount);
    }
}
