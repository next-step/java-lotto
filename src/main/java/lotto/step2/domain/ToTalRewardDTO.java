package lotto.step2.domain;

public class ToTalRewardDTO {
    private final int totalReward;
    
    public ToTalRewardDTO(ToTalReward totalReward) {
        this.totalReward = totalReward.getTotalReward();
    }
    
    public int getTotalReward() {
        return totalReward;
    }
}
