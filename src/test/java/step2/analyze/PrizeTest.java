package step2.analyze;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PrizeTest {
    @ParameterizedTest
    @CsvSource(value = {
            "3:5000",
            "4:50000",
            "5:15000000",
            "6:2000000000"
    }, delimiter = ':')
    @DisplayName("맞는 개수에 대한 상금 조회")
    void getPrice(int matchCount, int prize) {
        assertThat(Prize.getPrice(matchCount)).isEqualTo(prize);
    }
}