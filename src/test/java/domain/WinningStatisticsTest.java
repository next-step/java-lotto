package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {
    @Test
    public void 로또_결과를_입력받으면_매칭_결과를_반환한다() {
        //given
        List<Integer> lastWeekWinningResults = new ArrayList<>();
        lastWeekWinningResults.add(1);
        lastWeekWinningResults.add(3);
        lastWeekWinningResults.add(15);
        lastWeekWinningResults.add(17);
        lastWeekWinningResults.add(21);
        lastWeekWinningResults.add(35);
        WinningStatistics winningStatistics = new WinningStatistics(lastWeekWinningResults);

        int[] lottoResultWithFourthPrize = { 1, 3, 15, 7, 9, 11 };
        int[] lottoResultWithThirdPrize = { 1, 3, 15, 17, 9, 11 };
        int[] lottoResultWithSecondPrize = { 1, 3, 15, 17, 9, 21 };
        int[] lottoResultWithFirstPrize = { 1, 3, 15, 17, 21, 35 };

        //when
        winningStatistics.matchCount(lottoResultWithFourthPrize);
        winningStatistics.matchCount(lottoResultWithThirdPrize);
        winningStatistics.matchCount(lottoResultWithSecondPrize);
        winningStatistics.matchCount(lottoResultWithFirstPrize);

        //then
        assertThat(winningStatistics.getWinningResults()[0]).isEqualTo(1);
        assertThat(winningStatistics.getWinningResults()[1]).isEqualTo(1);
        assertThat(winningStatistics.getWinningResults()[2]).isEqualTo(1);
        assertThat(winningStatistics.getWinningResults()[3]).isEqualTo(1);
        assertThat(winningStatistics.getTotalWinnings()).isEqualTo(2001555000);

    }
}
