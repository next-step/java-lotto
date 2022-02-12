package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.rank.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {

    @DisplayName("(보너스가 안 맞는 경우) 매칭 갯수에 맞게 등수 찾기")
    @ParameterizedTest
    @CsvSource(value = {"6,FIRST", "5,THIRD", "4,FOURTH", "3,FIFTH", "2,NONE", "1,NONE", "0,NONE"})
    void 보너스_등수_계산(int matchCount, String expected) {
        boolean matchBonus = false;
        Rank actual = Rank.of(matchCount, matchBonus);
        assertThat(actual).isEqualTo(Rank.valueOf(expected));
    }

    @DisplayName("(보너스가 맞는 경우) 매칭 갯수에 맞게 등수 찾기")
    @ParameterizedTest
    @CsvSource(value = {"6,FIRST", "5,SECOND", "4,FOURTH", "3,FIFTH", "2,NONE", "1,NONE", "0,NONE"})
    void 등수_계산(int matchCount, String expected) {
        boolean matchBonus = true;
        Rank actual = Rank.of(matchCount, matchBonus);
        assertThat(actual).isEqualTo(Rank.valueOf(expected));
    }
}
