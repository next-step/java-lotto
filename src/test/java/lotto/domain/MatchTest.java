package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTest {

    @ParameterizedTest
    @CsvSource(value = {"1,false,NONE", "2,false,NONE", "3,false,THREE", "4,false,FOUR", "5,false,FIVE",
            "5,true,FIVE_BONUS", "6,false,SIX"})
    public void getMatch(int matchCount, boolean hasBonusNumber, String matchName) {
        assertThat(Match.of(matchCount, hasBonusNumber))
                .isEqualTo(Match.valueOf(matchName));
    }
}
