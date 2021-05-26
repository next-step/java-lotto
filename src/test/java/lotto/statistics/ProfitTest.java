package lotto.statistics;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProfitTest {

    @Test
    void ratio() {
        assertThat(Profit.ratioBy(1).toString()).isEqualTo("본전");
        assertThat(Profit.ratioBy(0).toString()).isEqualTo("손해");
        assertThat(Profit.ratioBy(1.1).toString()).isEqualTo("이익");
    }

}