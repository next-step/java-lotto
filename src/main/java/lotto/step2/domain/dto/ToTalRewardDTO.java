package lotto.step2.domain.dto;

import lotto.step2.domain.ToTalReward;

public class ToTalRewardDTO {
    private final int totalReward;
    
    public ToTalRewardDTO(ToTalReward totalReward) {
        this.totalReward = totalReward.getTotalReward();
    }
    
    public int getTotalReward() {
        return totalReward;
    }
}
