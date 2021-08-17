package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsTest {

    @DisplayName("당첨 개수 확인 테스트")
    @Test
    public void statisticMatchTest() {
        Statistics statistics = new Statistics();
        statistics.calculateRank(WinningLotto.FIRST, WinningLotto.FIRST_EARN_MONEY);
        assertThat(statistics.winningCount(WinningLotto.FIRST)).isEqualTo(1);
    }

    @DisplayName("당첨 금액 확인 테스트")
    @Test
    public void statisticEarnMoneyTest() {
        Statistics statistics = new Statistics();
        statistics.calculateRank(WinningLotto.FOURTH, WinningLotto.FOURTH_EARN_MONEY);
        statistics.setEarnMoneyPercentage(5000);
        assertThat(statistics.getEarnMoneyPercentage()).isEqualTo(1);
    }

}