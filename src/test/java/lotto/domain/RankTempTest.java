package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("NonAsciiCharacters")
class RankTempTest {

    @DisplayName("보너스볼이 반영된 등수를 가져온다.")
    @ParameterizedTest
    @CsvSource(value = {"5:false:THIRD", "5:true:SECOND"}, delimiter = ':')
    void returnRank_보너스볼이_반영된_등수(int matchingCount, boolean matchBonus, String rankName) {
        assertThat(RankTemp.returnRank(new MatchingCount(matchingCount), matchBonus).name()).isEqualTo(rankName);
    }

}
