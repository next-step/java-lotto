package lotto.step2.domain.strategy.dto;

public class PaymentInformationDTO {
    private final int numberOfTicketsPurchased;
    
    public PaymentInformationDTO(int numberOfTicketsPurchased) {
        this.numberOfTicketsPurchased = numberOfTicketsPurchased;
    }
    
    public int getNumberOfTicketsPurchased() {
        return numberOfTicketsPurchased;
    }
}
