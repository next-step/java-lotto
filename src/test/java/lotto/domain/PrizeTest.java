package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {

    @ParameterizedTest
    @CsvSource(value = {"0,0,0", "1,0,0", "2,0,0", "3,3,5000", "4,4,50000", "5,5,1500000", "6,6,2000000000"})
    void findPrize(int findCount, int expectedCount, int expectedAmount) {
        Prize prize = Prize.findPrize(findCount);
        assertThat(prize.getMatchCount()).isEqualTo(expectedCount);
        assertThat(prize.getAmount()).isEqualTo(expectedAmount);
    }
}
