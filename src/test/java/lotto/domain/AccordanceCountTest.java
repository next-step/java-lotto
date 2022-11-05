package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AccordanceCountTest {

    @DisplayName("총 당첨 금액 계산")
    @Test
    void calculateTotalPrizeTest() {
        AccordanceCount accordanceCount = new AccordanceCount(Map.of(
            WinningAccordance.FIFTH,
            3L,
            WinningAccordance.FOURTH,
            1L,
            WinningAccordance.THIRD,
            0L,
            WinningAccordance.SECOND,
            0L,
            WinningAccordance.FIRST,
            0L
        ));

        long result = accordanceCount.calculateTotalPrize();

        assertThat(result).isEqualTo(65000L);
    }
}
