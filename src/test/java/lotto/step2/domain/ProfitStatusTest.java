package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitStatusTest {

    @DisplayName("수익률이 1이면 본전이다")
    @Test
    void same(){
        double profitRate = 1.0;

        ProfitStatus profitStatus = ProfitStatus.from(profitRate);

        assertThat(profitStatus).isEqualTo(ProfitStatus.SAME);
        assertThat(profitStatus.getDescription()).isEqualTo("본전");
    }

    @DisplayName("수익률이 1보다 작으면 손해다")
    @Test
    void loss(){
        double profitRate = 0.25;

        ProfitStatus profitStatus = ProfitStatus.from(profitRate);

        assertThat(profitStatus).isEqualTo(ProfitStatus.LOSS);
        assertThat(profitStatus.getDescription()).isEqualTo("손해");
    }

    @DisplayName("수익률이 1보다 크면 이득이다")
    @Test
    void gain(){
        double profitRate = 1.25;

        ProfitStatus profitStatus = ProfitStatus.from(profitRate);

        assertThat(profitStatus).isEqualTo(ProfitStatus.GAIN);
        assertThat(profitStatus.getDescription()).isEqualTo("이득");
    }

}