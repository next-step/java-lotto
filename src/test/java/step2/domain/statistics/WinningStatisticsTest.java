package step2.domain.statistics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.utils.WinningStatisticsTestUtil;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticsTest {

    @Test
    @DisplayName("5등(3개 일치), 1개 구매에 대한 통계 테스트")
    void addTest() {
        final WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.add(3);
        System.out.println(winningStatistics);

        final WinningStatistics expected = WinningStatisticsTestUtil.createTestWinningStatistics(3, 1);
        System.out.println(expected);
        assertThat(winningStatistics).isEqualTo(expected);
    }

    @Test
    @DisplayName("4등(4개 일치), 2개 구매에 대한 통계 테스트")
    void addTest2() {
        final WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.add(4);
        winningStatistics.add(4);

        final WinningStatistics expected = WinningStatisticsTestUtil.createTestWinningStatistics(4, 2);
        System.out.println(expected);
        assertThat(winningStatistics).isEqualTo(expected);
    }
}