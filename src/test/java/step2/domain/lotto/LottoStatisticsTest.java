package step2.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoStatisticsTest {

    @DisplayName("수익률 계산 테스트")
    @CsvSource({"1000, 1000", "2000, 500", "4000, 3000"})
    @ParameterizedTest
    void getWinningRate(int purchasedAmount, int winningAmount) {
        // given
        LottoStatistics lottoStatistics = new LottoStatistics(purchasedAmount);

        // when
        double winningRate = lottoStatistics.getWinningRate(winningAmount);

        // then
        double actual = (double) winningAmount / purchasedAmount;
        Assertions.assertThat(actual).isEqualTo(winningRate);
    }
}