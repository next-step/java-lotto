package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("일치 개수를 입력하면 해당하는 등수의 상금을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"3,false,5000", "4,false,50000", "5,false,1500000", "5,true,30000000", "6,false,2000000000"})
    void valueOf(int matchCount, boolean matchBonus, int expectedPrizeMoney) {
        // given
        Rank rank = Rank.valueOf(matchCount, matchBonus);

        // when
        int prizeMoney = rank.getPrizeMoney();

        // then
        assertThat(prizeMoney).isEqualTo(expectedPrizeMoney);
    }
}
