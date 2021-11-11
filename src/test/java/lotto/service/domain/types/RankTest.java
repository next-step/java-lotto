package lotto.service.domain.types;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @CsvSource(value = {
            "0      |false      |MISS",
            "1      |false      |MISS",
            "2      |false      |MISS",
            "3      |false      |FIFTH",
            "4      |false      |FOURTH",
            "5      |false      |THIRD",
            "6      |false      |FIRST",

            "0      |true       |MISS",
            "1      |true       |MISS",
            "2      |true       |MISS",
            "3      |true       |FIFTH",
            "4      |true       |FOURTH",
            "5      |true       |SECOND",
            "6      |true       |FIRST"
    }, delimiter = '|')
    @DisplayName("배당표 값 확인")
    void convertRankByCountOfMatch(int countOfMatch, boolean matchBonus, Rank expected) {
        // given & when
        Rank rank = Rank.convertRankByCountOfMatch(countOfMatch, matchBonus);

        // then
        assertThat(rank).isNotNull();
        assertThat(rank).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 7, 8, 9})
    @DisplayName("잘못된 숫자 입력 시, MISS 반환")
    void valueOf_exception(int countOfMatch) {
        assertThat(Rank.convertRankByCountOfMatch(countOfMatch, false)).isEqualTo(Rank.MISS);
    }
}
