package lotto.step2.domain;

import lotto.step2.domain.strategy.shufflestrategy.ShuffleStrategy;

public class PaymentInformationDTO {
    private final ShuffleStrategy shuffleStrategy;
    private final int numberOfTicketsPurchased;
    
    public PaymentInformationDTO(ShuffleStrategy shuffleStrategy, int numberOfTicketsPurchased) {
        this.shuffleStrategy = shuffleStrategy;
        this.numberOfTicketsPurchased = numberOfTicketsPurchased;
    }
    
    public ShuffleStrategy getShuffleStrategy() {
        return shuffleStrategy;
    }
    
    public int getNumberOfTicketsPurchased() {
        return numberOfTicketsPurchased;
    }
}
