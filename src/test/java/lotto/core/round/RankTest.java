package lotto.core.round;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 등급")
class RankTest {

    @ParameterizedTest
    @CsvSource({
        "0,false", "1,false", "2,false",
        "0,true", "1,true", "2,true",
    })
    @DisplayName("꽝 확인")
    public void missTest(int countOfMatch, boolean matchBonus) {
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);

        assertThat(rank).isEqualTo(Rank.MISS);
    }

    @ParameterizedTest
    @CsvSource({"3,false", "3,true",})
    @DisplayName("5등 확인")
    public void fifthTest(int countOfMatch, boolean matchBonus) {
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);

        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @ParameterizedTest
    @CsvSource({"4,false", "4,true",})
    @DisplayName("4등 확인")
    public void fourthTest(int countOfMatch, boolean matchBonus) {
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);

        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("3등 확인")
    public void thirdTest() {
        Rank rank = Rank.valueOf(5, false);

        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("2등 확인")
    public void secondTest() {
        Rank rank = Rank.valueOf(5, true);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @ParameterizedTest
    @CsvSource({"6,false", "6,true",})
    @DisplayName("1등 확인")
    public void firstTest(int countOfMatch, boolean matchBonus) {
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);

        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("당청금이 존재하는 등급 확인")
    public void winningValuesTest() {
        List<Rank> ranks = Rank.winningValues();

        assertThat(ranks).containsExactly(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
    }

    @Test
    @DisplayName("로또 정답갯수가 동일한 등급 확인")
    public void duplicateMatchValuesTest() {
        List<Rank> ranks = Rank.duplicateMatchValues();

        assertThat(ranks).containsExactly(Rank.THIRD, Rank.SECOND);
    }

}