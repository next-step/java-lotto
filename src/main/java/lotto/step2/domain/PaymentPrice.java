package lotto.step2.domain;

import lotto.step2.dto.PaymentPriceDTO;

import java.util.Objects;

public class PaymentPrice {
    private static final int TICKET_PRICE = 1000;
    
    private final int paymentPrice;
    
    public PaymentPrice(int paymentPrice) {
        this.paymentPrice = paymentPrice;
    }
    
    public int numberOfTickets() {
        return paymentPrice / TICKET_PRICE;
    }
    
    public PaymentPriceDTO paymentPriceInformation() {
        return new PaymentPriceDTO(this);
    }
    
    public int getPaymentPrice() {
        return paymentPrice;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentPrice that = (PaymentPrice) o;
        return paymentPrice == that.paymentPrice;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(paymentPrice);
    }
}
