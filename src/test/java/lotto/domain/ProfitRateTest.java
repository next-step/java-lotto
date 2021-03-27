package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitRateTest {

    @Test
    @DisplayName("수익률 생성")
    public void create() throws Exception {
        ProfitRate profitRate = new ProfitRate(5000, 14000);
        assertThat(profitRate).isEqualTo(new ProfitRate(((double) 5000 / 14000)));
    }
}
