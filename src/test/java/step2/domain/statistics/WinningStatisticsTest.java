package step2.domain.statistics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.utils.WinningStatisticsTestUtil;
import step2.vo.Rank;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticsTest {

    @Test
    @DisplayName("5등(3개 일치) 1개, 총 1개 구매에 대한 통계")
    void addTest() {
        final WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.add(Rank.FIFTH);
        System.out.println(winningStatistics);

        final WinningStatistics expected = WinningStatisticsTestUtil.createTestWinningStatistics(3, 1);
        System.out.println(expected);
        assertThat(winningStatistics).isEqualTo(expected);
    }

    @Test
    @DisplayName("4등(4개 일치) 2개, 총 2개 구매에 대한 통계")
    void addTest2() {
        final WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.add(Rank.FOURTH);
        winningStatistics.add(Rank.FOURTH);

        final WinningStatistics expected = WinningStatisticsTestUtil.createTestWinningStatistics(4, 2);
        System.out.println(expected);
        assertThat(winningStatistics).isEqualTo(expected);
    }

    @Test
    @DisplayName("2등(5개일치, 보너스) 2개, 미당첨 1개, 총 2개 구매에 대한 통계") // todo
    void addTest3() {
        final WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.add(Rank.SECOND);
        winningStatistics.add(Rank.NONE);

        System.out.println(winningStatistics);
    }
}