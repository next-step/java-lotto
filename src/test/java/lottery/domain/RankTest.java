package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @CsvSource({"SIX, FIRST", "FIVE, SECOND", "FOUR, THIRD", "THREE, FIFTH", "ZERO, FAIL"})
    @DisplayName("맞춘 개수에 따른 당첨금액을 가져온다.")
    void valueOf_test(MatchCount matchCount, Rank expectedRank) {
        //when
        Rank rank = Rank.valueOf(matchCount);

        //then
        assertThat(rank).isEqualTo(expectedRank);
    }
}
