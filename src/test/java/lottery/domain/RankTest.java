package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @CsvSource({
                    "6, false, FIRST",
                    "5, true, SECOND",
                    "5, false, THIRD",
                    "4, false, FOURTH",
                    "3, false, FIFTH",
                    "0, false, FAIL"
            })
    @DisplayName("맞춘 개수와 보너스볼 맞춘 유무에 따른 당첨금액을 가져온다.")
    void valueOf_test(int matchCount, boolean matchBonus, Rank expectedRank) {
        //when
        Rank rank = Rank.valueOf(matchCount, matchBonus);

        //then
        assertThat(rank).isEqualTo(expectedRank);
    }
}
