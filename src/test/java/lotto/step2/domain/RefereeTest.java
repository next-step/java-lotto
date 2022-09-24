package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {
    @Test
    @DisplayName("총 수익률 계산하기")
    void yield() {
        double yield = Referee.yield(new PaymentPrice(14000).paymentPriceInformation(), new ToTalReward(5000).totalRewardInformation());
        assertThat(yield).isEqualTo(0.35);
    }
    
    @Test
    @DisplayName("총 당첨금 계산하기")
    void totalReward() {
        int totalReward = Referee.getTotalReward(Arrays.asList(MatchNumber.THREE, MatchNumber.THREE, MatchNumber.SIX));
        assertThat(totalReward).isEqualTo(2000010000);
    }
}
