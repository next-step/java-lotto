package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

class ProfitRateTest {

    @Test
    void 로또_수익률_객체_생성_및_내부값_정상() {
        // given, when, then
        assertThat(new ProfitRate(10000, 1000).getProfitRate()).isCloseTo(10.0,
                Percentage.withPercentage(99.9));
    }
}
