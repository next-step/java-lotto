package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class RankTest {

    @DisplayName("맞춘 횟수에 맞는 등수를 가져온다.")
    @ParameterizedTest
    @CsvSource(value = {"0:MISS", "1:MISS", "2:MISS", "3:FOURTH", "4:THIRD", "5:SECOND", "6:FIRST"}, delimiter = ':')
    void returnRank_맞춘_횟수에_맞는_등수(int matchingCount, String rankName) {
        assertThat(Rank.returnRank(new MatchingCount(matchingCount)).name()).isEqualTo(rankName);
    }

    @DisplayName("등수에 맞는 금액을 가져온다.")
    @ParameterizedTest
    @CsvSource(value = {"MISS:1:0", "FOURTH:2:10000", "THIRD:5:250000", "SECOND:2:3000000", "FIRST:1:2000000000"}, delimiter = ':')
    void getWinningMoney_등수에_맞는_금액(String rankName, int count, int totalMoney) {
        assertThat(Rank.valueOf(rankName).totalWinningMoney(new MatchingCount(count))).isEqualTo(totalMoney);
    }

}
