package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.model.Lottos;
import study.lotto.model.Statistics;
import study.lotto.model.WinningLotto;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class StatisticsTest {

    @DisplayName("수익률 계산")
    @Test
    void calculate_earning_rate() {
        Lottos lottos = Lottos.of(10);

        String[] split = "1, 2, 3, 4, 5, 6".split(", ");
        WinningLotto winningLotto = WinningLotto.of(split);
        Statistics statistics = new Statistics(lottos);
        statistics.calculateStatistics(winningLotto, 7);

        assertThat(statistics.calculateEarningRate(14000))
                .isGreaterThanOrEqualTo(BigDecimal.ZERO);
    }

    @DisplayName("당첨금 통계 계산 - 당첨 번호와 보너스 번호가 중복되어 IllegalArgumentException 발생")
    @Test
    void calculate_statistics_with_error() {
        Lottos lottos = Lottos.of(10);

        String[] split = "1, 2, 3, 4, 5, 6".split(", ");
        WinningLotto winningLotto = WinningLotto.of(split);
        Statistics statistics = new Statistics(lottos);

        assertThatIllegalArgumentException().isThrownBy(() -> statistics.calculateStatistics(winningLotto, 1));
    }
}
