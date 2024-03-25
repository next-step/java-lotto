package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.grade.Grade;
import lotto.domain.lotto.PurchaseAmount;
import lotto.domain.winning.WinningStatistic;
import lotto.error.exception.NotExistGradeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticTest {

    @Test
    @DisplayName("WinningStatistic은 Grade를 통해 각 등수를 계산해야한다.")
    public void WinningStatistic_Should_Calculate_Rank_Count() {
        WinningStatistic winningStatistic = new WinningStatistic(new PurchaseAmount(10000));

        winningStatistic.calculateWinningStatistic(Grade.FIRST_GRADE);
        winningStatistic.calculateWinningStatistic(Grade.SECOND_GRADE);
        winningStatistic.calculateWinningStatistic(Grade.THIRD_GRADE);
        winningStatistic.calculateWinningStatistic(Grade.FOUR_GRADE);

        assertThat(winningStatistic.getFirstGradeCount()).isEqualTo(1);
        assertThat(winningStatistic.getSecondGradeCount()).isEqualTo(1);
        assertThat(winningStatistic.getThirdGradeCount()).isEqualTo(1);
        assertThat(winningStatistic.getForthGradeCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("WinningStatistic은 수익률을 계산해야 한다.")
    public void WinningStatistic_Should_Calculate_Profit_Rate() {
        WinningStatistic winningStatistic = new WinningStatistic(new PurchaseAmount(14000));

        winningStatistic.calculateWinningStatistic(Grade.FOUR_GRADE);
        double profitRate = winningStatistic.calculateProfitRate();

        assertThat(profitRate).isEqualTo(0.35);
    }

    @Test
    @DisplayName("WinningStatistic은 존재하지 않는 Grade를 조회할 경우 예외를 발생한다")
    public void WinningStatistic_Should_Throw_Exception_When_Winning_Statistic_None_Existent_Grade() {
        WinningStatistic winningStatistic = new WinningStatistic(new PurchaseAmount(10000));

        assertThatThrownBy(() -> winningStatistic.getGradeCount(Grade.UN_LUCKY_GRADE))
            .isInstanceOf(NotExistGradeException.class)
            .hasMessage("존재하지 않는 순위입니다. 입력값: UN_LUCKY_GRADE");
    }
}


