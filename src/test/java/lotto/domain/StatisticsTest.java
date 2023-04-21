package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsTest {

    @ParameterizedTest
    @CsvSource(value = {"6,2000000000", "5,1500000", "4,50000", "3,5000"})
    @DisplayName("금액 테스트")
    void prizeTest(int matchingBall, int prize) {
        assertThat(Statistics.getPrize(matchingBall))
                .isEqualTo(prize);
    }

}