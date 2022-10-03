package lotto.domain.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {

    @DisplayName("총 금액은 당첨된 갯수 곱하기 상금이다")
    @Test
    void amountByCount() {
        assertThat(LottoPrize.FOURTH.amountByCount(10)).isEqualTo(BigDecimal.valueOf(500_000L));
    }
}