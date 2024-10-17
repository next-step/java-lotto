package lottogame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankTest {

    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "2, false, NONE",
            "1, false, NONE",
            "0, false, NONE"
    })
    @DisplayName("일치하는 개수와 보너스 번호 일치 여부에 따라 올바른 Rank를 반환한다")
    void from(int matchCount, boolean matchBonus, Rank expectedRank) {
        assertEquals(expectedRank, Rank.from(matchCount, matchBonus));
    }

}