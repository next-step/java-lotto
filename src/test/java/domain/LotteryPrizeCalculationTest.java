package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LotteryPrizeCalculationTest {

    @Test
    @DisplayName("0 ~ 2개 당첨은 꽝이 나와야한다 (꽝은 당첨금 0)")
    public void checkWinningPrizeNothing() {
        Assertions.assertAll(
                () -> assertThat(LotteryPrizeCalculation.winningAmount(0, 0)).isEqualTo(0),
                () -> assertThat(LotteryPrizeCalculation.winningAmount(1, 0)).isEqualTo(0),
                () -> assertThat(LotteryPrizeCalculation.winningAmount(2, 0)).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("3개 이상은 당첨금액이 있다.")
    public void checkWinningPrize() {
        Assertions.assertAll(
                () -> assertThat(LotteryPrizeCalculation.winningAmount(3, 0)).isEqualTo(5000),
                () -> assertThat(LotteryPrizeCalculation.winningAmount(4, 0)).isEqualTo(50000),
                () -> assertThat(LotteryPrizeCalculation.winningAmount(5, 0)).isEqualTo(1500000),
                () -> assertThat(LotteryPrizeCalculation.winningAmount(5, 1)).isEqualTo(30000000),
                () -> assertThat(LotteryPrizeCalculation.winningAmount(6, 0)).isEqualTo(2000000000)
        );
    }
}
