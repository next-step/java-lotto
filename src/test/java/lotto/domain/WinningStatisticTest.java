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
                new MatchingResult(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new MatchingResult(Arrays.asList(2, 3, 4, 5, 6)),
                new MatchingResult(Arrays.asList(3, 4, 5, 6)),
                new MatchingResult(Arrays.asList(1, 2, 5, 6)),
                new MatchingResult(Arrays.asList(1, 2, 3)),
                new MatchingResult(Arrays.asList(2, 3, 4)),
                new MatchingResult(Arrays.asList(2, 3, 5)),
                new MatchingResult(Arrays.asList(1, 3, 6)),
                new MatchingResult(Arrays.asList(1, 2, 3, 6))
        );

        WinningStatistic winningStatistic = new WinningStatistic(matchingResults);
        winningStatistic.calculateIncome();

        assertThat(winningStatistic.getWinningGrades().get(3).getCount()).isEqualTo(4);
        assertThat(winningStatistic.getWinningGrades().get(4).getCount()).isEqualTo(3);
        assertThat(winningStatistic.getWinningGrades().get(5).getCount()).isEqualTo(1);
        assertThat(winningStatistic.getWinningGrades().get(6).getCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("총 수익률 계산 테스트")
    void calculate_total_income_rate() {

        List<MatchingResult> matchingResults = Arrays.asList(
                new MatchingResult(Arrays.asList(3, 4, 5, 6)),
                new MatchingResult(Arrays.asList(1, 2, 5, 6)),
                new MatchingResult(Arrays.asList(1, 2, 3)),
                new MatchingResult(Arrays.asList(2, 3, 4)),
                new MatchingResult(Arrays.asList(2, 3, 5)),
                new MatchingResult(Arrays.asList(1, 3, 6)),
                new MatchingResult(Arrays.asList(1, 2, 3, 6))
        );

        WinningStatistic winningStatistic = new WinningStatistic(matchingResults);
        winningStatistic.calculateIncome();

        assertThat(winningStatistic.totalIncomeRate(500000)).isEqualTo(0.34);
    }

}
