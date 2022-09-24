package lotto.step2.domain.dto;

import lotto.step2.domain.ToTalReward;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ToTalRewardDTOTest {
    
    @Test
    void getTotalReward() {
        ToTalRewardDTO toTalRewardDTO = new ToTalRewardDTO(new ToTalReward(5000));
        assertThat(toTalRewardDTO.getTotalReward()).isEqualTo(5000);
    }
}