package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @CsvSource({"6,FIRST","5,THIRD","4,FOURTH","3,FIFTH"})
    void 일치하는_공_개수로_Rank_를_리턴한다(int countOfMatch, Rank expected) {
        assertThat(Rank.valueOf(countOfMatch).get()).isEqualTo(expected);
    }

}
