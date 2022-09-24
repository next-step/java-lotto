package lotto.step2.domain;

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
}
