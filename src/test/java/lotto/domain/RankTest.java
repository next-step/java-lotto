package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @ParameterizedTest
    @CsvSource(value = {"6:false:FIRST", "6:true:FIRST", "5:true:SECOND", "5:false:THIRD", "4:false:FOURTH", "3:false:FIFTH", "2:false:MISS"}, delimiter = ':')
    @DisplayName("findRank(): matchCount와 보너스볼 매치 여부를 고려하여 Rank를 반환한다.")
    void testFindRank(int matchCount, boolean matchBonus, Rank expected) {
        assertThat(Rank.findRank(matchCount, matchBonus)).isEqualTo(expected);
    }
}
