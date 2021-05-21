package lotto.view;

import lotto.domain.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoYieldTest {
    @Test
    @DisplayName("본전치기를 하면 1.0이 기본값이다")
    void 본전치기를_하면_1_0이_기본이다() {
        LottoYield lottoYield = new LottoYield(new PositiveNumber(1000), new PositiveNumber(1000));

        assertThat(lottoYield.calc())
                .isEqualTo(1.0);
    }
}