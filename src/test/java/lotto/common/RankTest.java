package lotto.common;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("로또 등수")
class RankTest {

    @DisplayName("[성공] 가져오기 - withMatchBonus")
    @ParameterizedTest
    @CsvSource(value = {
        "6,true,FIRST",
        "6,false,FIRST",
        "5,true,SECOND",
        "5,false,THIRD",
        "4,true,FOURTH",
        "4,false,FOURTH",
        "3,true,FIFTH",
        "3,false,FIFTH",
        "2,false,MISS",
    })
    public void valueOf_withMatchBonus(int countOfMatch, boolean matchBonus, Rank expected) {
        // given

        // when
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);

        // then
        assertThat(rank).isEqualTo(expected);
    }

    @DisplayName("[성공] 가져오기 - withoutMatchBonus")
    @ParameterizedTest
    @CsvSource(value = {
        "6,FIRST",
        "5,THIRD",
        "4,FOURTH",
        "3,FIFTH",
        "2,MISS",
    })
    public void valueOf_withoutMatchBonus(int countOfMatch, Rank matchBonus) {
        // given

        // when
        Rank rank = Rank.valueOf(countOfMatch);

        // then
        assertThat(rank).isEqualTo(matchBonus);
    }
}
