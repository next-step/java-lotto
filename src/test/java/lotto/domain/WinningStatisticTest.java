package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
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

        Arrays.asList(Grade.FIRST_GRADE, Grade.SECOND_GRADE, Grade.THIRD_GRADE, Grade.FOUR_GRADE)
            .forEach(winningStatistic::calculateWinningStatistic);

        assertThat(winningStatistic.getGradeCount(Grade.FIRST_GRADE)).isEqualTo(1);
        assertThat(winningStatistic.getGradeCount(Grade.SECOND_GRADE)).isEqualTo(1);
        assertThat(winningStatistic.getGradeCount(Grade.THIRD_GRADE)).isEqualTo(1);
        assertThat(winningStatistic.getGradeCount(Grade.FOUR_GRADE)).isEqualTo(1);
    }

    @Test
    @DisplayName("WinningStatistic은 수익률을 계산해야 한다.")
    public void WinningStatistic_Should_Calculate_Profit_Rate() {
        WinningStatistic winningStatistic = new WinningStatistic(new PurchaseAmount(14000));

        winningStatistic.calculateWinningStatistic(Grade.FOUR_GRADE);
        double profitRate = winningStatistic.calculateProfitRate();

        assertThat(profitRate).isEqualTo(0.35);
    }
}


