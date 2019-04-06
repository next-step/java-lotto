package lotto.domain;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {
    @Test
    public void 수익률_계산() {
        // given
        final Map<WinningOrder, Long> values = new HashMap<>();
        values.put(WinningOrder.FIRST_PLACE, 1L);
        final WinningStatistics winningStatistics = new WinningStatistics(values);

        // when
        final BigDecimal roi = winningStatistics.getRoi(0);

        // then
        assertThat(roi).isEqualTo(WinningOrder.FIRST_PLACE.getAmount().divide(Lotto.PRICE));
    }

    @Test
    public void 수익률_제로() {
        // given
        final Map<WinningOrder, Long> values = new HashMap<>();
        final WinningStatistics winningStatistics = new WinningStatistics(values);

        // when
        final BigDecimal roi = winningStatistics.getRoi(0);

        // then
        assertThat(roi).isEqualTo(BigDecimal.ZERO);
    }
}