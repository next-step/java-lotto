package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsTest {

    @ParameterizedTest
    @CsvSource(value = {"6,2000000000", "5,1500000", "4,50000", "3,5000", "2,0", "1,0", "0,0"})
    @DisplayName("금액 테스트")
    void prizeTest(int matchingBall, int prize) {
        Statistics statistics = Statistics.init(matchingBall, false);
        assertThat(statistics.getPrize())
                .isEqualTo(prize);
    }

    @Test
    @DisplayName("보너스 번호 2등 테스트")
    void secondPrizeTest() {
        Statistics statistics = Statistics.init(5, true);
        assertThat(statistics.getPrize())
                .isEqualTo(30_000_000);
    }
    
}