package lotto.step2.domain;

public class ToTalReward {
    private final int totalReward;
    
    public ToTalReward(int totalReward) {
        this.totalReward = totalReward;
    }
    
    public ToTalRewardDTO totalRewardInformation() {
        return new ToTalRewardDTO(this);
    }
    
    public int getTotalReward() {
        return totalReward;
    }
}
