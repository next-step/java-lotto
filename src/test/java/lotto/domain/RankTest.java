package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @CsvSource({"6,false,FIRST", "5,true,SECOND", "5,false,THIRD", "4,false,FOURTH", "3,false,FIFTH"})
    void 일치하는_공_개수로_Rank_를_리턴한다(int countOfMatch, boolean bonusMatch, Rank expected) {
        assertThat(Rank.valueOf(countOfMatch, bonusMatch).get()).isEqualTo(expected);
    }

}
