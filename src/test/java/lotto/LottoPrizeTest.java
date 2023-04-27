package lotto;

import lotto.domain.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
public class LottoPrizeTest {
    @DisplayName("로또 번호가 일치하는 수에 따라 상금을 구한다")
    @ParameterizedTest
    @CsvSource(value = {"6, 2_000_000_000", "5, 1_500_000", "4, 50_000", "3, 5_000"})
    void lottoPrize(int rankCount, int winningMoney) {
        LottoPrize lottoPrize = LottoPrize.getWinningPrize(rankCount);
        assertThat(lottoPrize.money()).isEqualTo(winningMoney);
    }
}
