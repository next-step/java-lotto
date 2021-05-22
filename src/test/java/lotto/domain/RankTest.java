package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("일치 개수를 입력하면 해당하는 등수의 상금을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"3,5000", "4,50000", "5,1500000", "6,2000000000"})
    void valueOf(int matchCount, int expectedPrizeMoney) {
        // given
        Rank rank = Rank.valueOf(matchCount);

        // when
        int prizeMoney = rank.getPrizeMoney();

        // then
        assertThat(prizeMoney).isEqualTo(expectedPrizeMoney);
    }
}
