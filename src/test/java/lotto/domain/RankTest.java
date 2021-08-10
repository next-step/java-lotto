package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class RankTest {

    @DisplayName("보너스볼이 반영된 등수를 가져온다.")
    @ParameterizedTest
    @CsvSource(value = {"5:false:THIRD", "5:true:SECOND"}, delimiter = ':')
    void returnRank_보너스볼이_반영된_등수(int matchingCount, boolean matchBonus, String rankName) {
        assertThat(Rank.returnRank(new MatchingCount(matchingCount), matchBonus).name()).isEqualTo(rankName);
    }

    @DisplayName("보너스볼을 못맞춘 경우 - 맞춘 횟수에 맞는 등수를 가져온다.")
    @ParameterizedTest
    @CsvSource(value = {"0:false:MISS", "1:false:MISS", "2:false:MISS", "3:false:FIFTH", "4:false:FOURTH", "5:false:THIRD", "6:false:FIRST"}, delimiter = ':')
    void returnRank_보너스볼을_못맞춘_경우_맞춘_횟수에_맞는_등수(int matchingCount, boolean matchBonus, String rankName) {
        assertThat(Rank.returnRank(new MatchingCount(matchingCount), matchBonus).name()).isEqualTo(rankName);
    }

    @DisplayName("보너스볼을 맞춘 경우 - 맞춘 횟수에 맞는 등수를 가져온다.")
    @ParameterizedTest
    @CsvSource(value = {"0:true:MISS", "1:true:MISS", "2:true:MISS", "3:true:FIFTH", "4:true:FOURTH", "5:true:SECOND", "6:true:FIRST"}, delimiter = ':')
    void returnRank_보너스볼을_맞춘_경우_맞춘_횟수에_맞는_등수(int matchingCount, boolean matchBonus, String rankName) {
        assertThat(Rank.returnRank(new MatchingCount(matchingCount), matchBonus).name()).isEqualTo(rankName);
    }

    @DisplayName("등수에 맞는 금액을 가져온다.")
    @ParameterizedTest
    @CsvSource(value = {"MISS:0", "FIFTH:5000", "FOURTH:50000", "THIRD:1500000", "SECOND:30000000", "FIRST:2000000000"}, delimiter = ':')
    void getWinningMoney_등수에_맞는_금액(String rankName, int totalMoney) {
        assertThat(Rank.valueOf(rankName).totalWinningMoney(1)).isEqualTo(totalMoney);
    }

}
