package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.LottoResult;
import study.lotto.domain.Lottos;
import study.lotto.domain.WinningLottoInfo;
import study.lotto.utils.StatisticUtils;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StatisticsTest {

    @DisplayName("수익률 계산")
    @Test
    void calculate_earning_rate() {
        Lottos lottos = Lottos.of(10);

        String[] split = "1, 2, 3, 4, 5, 6".split(", ");
        WinningLottoInfo winningLottoInfo = WinningLottoInfo.of(split, 7);

        LottoResult lottoResult = LottoResult.produce(lottos, winningLottoInfo);

        assertThat(StatisticUtils.calculateEarningRate(14000, lottoResult))
                .isGreaterThanOrEqualTo(BigDecimal.ZERO);
    }

    @DisplayName("당첨금 통계 계산 - 당첨 번호와 보너스 번호가 중복되어 IllegalArgumentException 발생")
    @Test
    void calculate_statistics_with_error() {
        String[] split = "1, 2, 3, 4, 5, 6".split(", ");

        assertThatIllegalArgumentException().isThrownBy(() -> WinningLottoInfo.of(split, 1));
    }
}
