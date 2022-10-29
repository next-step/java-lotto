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
            WinningAccordance.THREE,
            3L,
            WinningAccordance.FOUR,
            1L,
            WinningAccordance.FIVE,
            0L,
            WinningAccordance.SIX,
            0L
        ));

        long result = accordanceCount.calculateTotalPrize();

        assertThat(result).isEqualTo(65000L);
    }
}
