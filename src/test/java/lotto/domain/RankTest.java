package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @CsvSource(value = {"0,false,0,0", "1,false,0,0", "2,false,0,0", "3,false,3,5000", "4,false,4,50000",
            "5,false,5,1500000", "5,true,5,30000000", "6,false,6,2000000000"})
    void findPrize(int findCount, boolean matchBonus, int expectedCount, int expectedAmount) {
        Rank rank = Rank.valueOf(findCount, matchBonus);
        assertThat(rank.matchCount()).isEqualTo(expectedCount);
        assertThat(rank.getAmount()).isEqualTo(expectedAmount);
    }
}
