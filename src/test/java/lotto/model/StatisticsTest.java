package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {
    @ParameterizedTest
    @CsvSource({
            "14000, 0.35",
            "10000, 0.5",
            "5000, 1",
            "1000, 5"
    })
    @DisplayName("Statistics 객체로 수익률을 계산할 수 있다.")
    void calculate_ProfitRate(int investment, double expectedProfitRate) {
        Statistics statistics = new Statistics();
        statistics.put(Rank.FIFTH);
        assertThat(statistics.calculateProfitRate(Money.valueOf(investment))).isEqualTo(expectedProfitRate);
    }

    @Test
    @DisplayName("Statistics 객체는 각 Rank별 당첨 횟수를 저장한다.")
    void count_NumberOfWinningByRank() {
        int countOfWinning = 10;
        Rank rank = Rank.FIRST;

        Statistics statistics = new Statistics();
        for (int i = 0; i < countOfWinning; i++) {
            statistics.put(rank);
        }
        assertThat(statistics.getCountOfWinning(rank)).isEqualTo(countOfWinning);
    }

    @Test
    @DisplayName("당첨되지 않은 Rank의 당첨 횟수는 0이다.")
    void count_NumberOfMissingCountByRank() {
        Statistics statistics = new Statistics();
        assertThat(statistics.getCountOfWinning(Rank.FIRST)).isEqualTo(0);
    }
}
