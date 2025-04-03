package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {
    @ParameterizedTest
    @DisplayName("matchCount에 매칭되는 Rank를 반환한다.")
    @CsvSource({
            "0, false, NO_MATCH",
            "1, false, NO_MATCH",
            "1, true, NO_MATCH",
            "3, true, NO_MATCH",
            "3, false, THREE_MATCH",
            "4, false, FOUR_MATCH",
            "5, false, FIVE_MATCH",
            "5, true, FIVE_MATCH_BONUS",
            "6, false, SIX_MATCH",
    })
    void valueOfTest(int matchCount, boolean bonusMatch, Rank expected) {
        Rank result = Rank.valueOf(matchCount, bonusMatch);

        Assertions.assertEquals(result, expected);
    }
}
