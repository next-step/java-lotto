package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @ParameterizedTest
    @CsvSource({"6,true", "6,false"})
    void 랭크_1등(int countOfMatch, boolean matchBonus) {
        assertThat(Rank.valueOf(countOfMatch, matchBonus)).isEqualTo(Rank.FIRST);
    }

    @Test
    void 랭크_2등() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    void 랭크_3등() {
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
    }

    @ParameterizedTest
    @CsvSource({"4,true", "4,false"})
    void 랭크_4등(int countOfMatch, boolean matchBonus) {
        assertThat(Rank.valueOf(countOfMatch, matchBonus)).isEqualTo(Rank.FOURTH);
    }

    @ParameterizedTest
    @CsvSource({"3,true", "3,false"})
    void 랭크_5등(int countOfMatch, boolean matchBonus) {
        assertThat(Rank.valueOf(countOfMatch, matchBonus)).isEqualTo(Rank.FIFTH);
    }

    @ParameterizedTest
    @CsvSource({"2,true", "2,false", "1,true", "1,false", "0,true", "0,false"})
    void 랭크_MISS(int countOfMatch, boolean matchBonus) {
        assertThat(Rank.valueOf(countOfMatch, matchBonus)).isEqualTo(Rank.MISS);
    }
}
