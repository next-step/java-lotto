package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @CsvSource(value = {"0,0,0", "1,0,0", "2,0,0", "3,3,5000", "4,4,50000", "5,5,1500000", "6,6,2000000000"})
    void findPrize(int findCount, int expectedCount, int expectedAmount) {
        Rank rank = Rank.valueOf(findCount);
        assertThat(rank.getMatchCount()).isEqualTo(expectedCount);
        assertThat(rank.getAmount()).isEqualTo(expectedAmount);
    }
}
