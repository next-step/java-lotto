package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticTest {

    @Test
    @DisplayName("등수별 당첨 개수 확인 테스트")
    void winning_count_test() {

        List<MatchingResult> matchingResults = Arrays.asList(
                new MatchingResult(6, false),
                new MatchingResult(5, true),
                new MatchingResult(5, false),
                new MatchingResult(4, false),
                new MatchingResult(3, true),
                new MatchingResult(3, true),
                new MatchingResult(3, false),
                new MatchingResult(3, false),
                new MatchingResult(4, true)
        );

        WinningStatistic winningStatistic = new WinningStatistic(matchingResults);

        assertThat(winningStatistic.getWinningGrades().get(WinningPrice.FIFTH).getCount()).isEqualTo(4);
        assertThat(winningStatistic.getWinningGrades().get(WinningPrice.FOURTH).getCount()).isEqualTo(2);
        assertThat(winningStatistic.getWinningGrades().get(WinningPrice.THIRD).getCount()).isEqualTo(1);
        assertThat(winningStatistic.getWinningGrades().get(WinningPrice.SECOND).getCount()).isEqualTo(1);
        assertThat(winningStatistic.getWinningGrades().get(WinningPrice.FIRST).getCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("총 수익률 계산 테스트")
    void calculate_total_income_rate() {

        List<MatchingResult> matchingResults = Arrays.asList(
                new MatchingResult(4, true),
                new MatchingResult(4, false),
                new MatchingResult(3, false),
                new MatchingResult(3, false),
                new MatchingResult(3, true),
                new MatchingResult(3, true),
                new MatchingResult(4, false)
        );

        WinningStatistic winningStatistic = new WinningStatistic(matchingResults);

        assertThat(winningStatistic.totalIncomeRate(500000)).isEqualTo(0.34);
    }

}
