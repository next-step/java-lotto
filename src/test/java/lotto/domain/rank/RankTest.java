package lotto.domain.rank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class RankTest {
    @DisplayName("Rank 찾기")
    @ParameterizedTest
    @CsvSource(value = {
            "6:true:FIRST", "6:false:FIRST",
            "5:true:SECOND",
            "5:false:THIRD",
            "4:true:FOURTH", "4:false:FOURTH",
            "3:true:FIFTH", "3:false:FIFTH",
            "2:true:NONE", "2:false:NONE",
            "0:true:NONE", "0:false:NONE",
    }, delimiter = ':')
    void valueOf(final int countOfMatch, final boolean matchBonus, final Rank rank) {
        // when
        final Rank result = Rank.valueOf(countOfMatch, matchBonus);

        // then
        assertThat(result).isEqualTo(rank);
    }
}