package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class AccordanceCountTest {

    @DisplayName("총 담첨 금액 계산")
    @Test
    void calculateTotalPrize() {
        AccordanceCount accordanceCount = new AccordanceCount(
                Map.of(
                    WinningAccordance.THREE, 3L,
                    WinningAccordance.FOUR, 1L,
                    WinningAccordance.FIVE, 0L,
                    WinningAccordance.SIX, 0L
                )
        );

        long result = accordanceCount.calculateTotalPrize();

        assertThat(result).isEqualTo(65000L);
    }
}
