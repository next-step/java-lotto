package lotto.statistics;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProfitTest {

    @Test
    void ratio() {
        assertThat(Profit.messageByRatio(1.000001)).isEqualTo("이익");
        assertThat(Profit.messageByRatio(1)).isEqualTo("본전");
        assertThat(Profit.messageByRatio(0.999999)).isEqualTo("손해");
    }

}