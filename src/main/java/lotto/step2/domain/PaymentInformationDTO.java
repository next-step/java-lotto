package lotto.step2.domain;

import lotto.step2.domain.strategy.shufflestrategy.ShuffleStrategy;

public class PaymentInformationDTO {
    private final ShuffleStrategy shuffleStrategy;
    private final int numberOfIssues;
    
    public PaymentInformationDTO(ShuffleStrategy shuffleStrategy, int numberOfIssues) {
        this.shuffleStrategy = shuffleStrategy;
        this.numberOfIssues = numberOfIssues;
    }
    
    public ShuffleStrategy getShuffleStrategy() {
        return shuffleStrategy;
    }
    
    public int getNumberOfIssues() {
        return numberOfIssues;
    }
}
