package lotto.type;

import controller.WinningStatistic;
import lotto.WinningAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticTest {
    @Test
    @DisplayName("[WinningStatistic] 최초 생성 시 각 당첨 등수값이 0으로 초기화")
    void shouldBeInitializedWithZeroCounts() {
        WinningStatistic statistic = new WinningStatistic();

        for (WinningLevel rank : WinningLevel.values()) {
            assertThat(statistic.getOccurs(rank)).isZero();
        }
    }

    @Test
    @DisplayName("[WinningStatistic.occurs] 당첨이 발생했음을 알리면 -> 당첨횟수 1 증가")
    void occursShouldIncreaseCountByOne() {
        WinningStatistic statistic = new WinningStatistic();
        WinningLevel rank = WinningLevel.FIRST;

        statistic.occurs(rank);

        assertThat(statistic.getOccurs(rank)).isEqualTo(1);
    }

    @Test
    @DisplayName("[WinningStatistic.getAmount] 당첨 횟수를 알리면 -> 총 당첨금액 계산")
    void getTotalWinAmountShouldReturnCorrectSum() {
        WinningStatistic statistic = new WinningStatistic();
        statistic.occurs(WinningLevel.FIRST);
        statistic.occurs(WinningLevel.THIRD);
        statistic.occurs(WinningLevel.THIRD);

        WinningAmount expectedAmount = WinningLevel.FIRST.getAmount()
                .add(WinningLevel.THIRD.getAmount().multiply(2));

        assertThat(statistic.getTotalWinAmount()).isEqualTo(expectedAmount);
    }
}
