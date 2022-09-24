package lotto.step2.domain;

public class PaymentPriceDTO {
    private final int paymentPrice;
    
    public PaymentPriceDTO(PaymentPrice paymentPrice) {
        this.paymentPrice = paymentPrice.getPaymentPrice();
    }
    
    public int getPaymentPrice() {
        return paymentPrice;
    }
}
