package lotto.step2.domain;

import lotto.step2.domain.dto.ToTalRewardDTO;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ToTalRewardTest {
    
    @Test
    void totalRewardInformation() {
        ToTalRewardDTO toTalRewardDTO = new ToTalReward(5000).totalRewardInformation();
        assertThat(toTalRewardDTO.getTotalReward()).isEqualTo(5000);
    }
}