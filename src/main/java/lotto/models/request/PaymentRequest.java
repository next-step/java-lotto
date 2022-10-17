package lotto.models.request;

public class PaymentRequest {
    private final int payment;

    private PaymentRequest(int payment) {
        this.payment = payment;
    }

    public int getPayment() {
        return payment;
    }

    public static PaymentRequest of(int payment) {
        return new PaymentRequest(payment);
    }
}
