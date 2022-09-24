package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {
    @Test
    @DisplayName("총 수익률 계산하기")
    void yield() {
        Referee referee = new Referee();
        double yield = referee.yield(new PaymentPrice(14000), new ToTalReward(5000));
        assertThat(yield).isEqualTo(0.35);
    }
}
