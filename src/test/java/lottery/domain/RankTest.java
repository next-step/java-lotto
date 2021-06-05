package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @CsvSource({"6, FIRST", "5, SECOND", "4, THIRD", "3, FOUR", "0, FAIL"})
    @DisplayName("맞춘 개수에 따른 당첨금액을 가져온다.")
    void valueOf_test(Integer matchCount, Rank expectedRank) {
        //when
        Rank rank = Rank.valueOf(matchCount);

        //then
        assertThat(rank).isEqualTo(expectedRank);
    }
}
