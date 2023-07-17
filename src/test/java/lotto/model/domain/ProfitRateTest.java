package lotto.model.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ProfitRateTest {

    @Test
    void 수익률_객체_생성_성공() {
        assertThatNoException().isThrownBy(() -> ProfitRate.valueOf(0.1));
    }
}
