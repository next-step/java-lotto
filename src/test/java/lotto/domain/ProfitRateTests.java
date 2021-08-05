package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitRateTests {

    @DisplayName("Profit Rate 생성 테스트")
    @Test
    void create(){
        ProfitRate profitRate = ProfitRate.of(4.0);

        assertThat(profitRate).isEqualTo(ProfitRate.of(4.0));
    }

    @Test
    void getProfitTest(){
        ProfitRate profitRate = ProfitRate.of(4.0);

        assertThat(profitRate.value()).isEqualTo(4.0);
    }
}
