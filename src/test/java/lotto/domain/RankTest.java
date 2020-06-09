package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @CsvSource(value = {"true,SECOND", "false,THIRD"})
    @DisplayName("2,3등 판별")
    void valueOf(boolean matchBonus, String expected) {
        Rank rank = Rank.valueOf(5, matchBonus);
        Rank expectRank = Rank.valueOf(expected);

        assertThat(rank).isEqualTo(expectRank);
    }
}
