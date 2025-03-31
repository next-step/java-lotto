package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {
    @ParameterizedTest
    @DisplayName("matchCount에 매칭되는 Rank를 반환한다.")
    @CsvSource({
            "0, NO_MATCH",
            "1, ONE_MATCH",
            "2, TWO_MATCH",
            "3, THREE_MATCH",
            "4, FOUR_MATCH",
            "5, FIVE_MATCH",
            "6, SIX_MATCH",
            "7, NO_MATCH"
    })
    void valueOfTest(int input, Rank expected) {
        Rank result = Rank.valueOf(input);

        Assertions.assertEquals(result, expected);
    }
}
