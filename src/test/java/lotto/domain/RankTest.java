package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @DisplayName("당첨번호 갯수에 일치하는 타입이 존재하면 해당 등수를 반환한다 (보너스 당첨 안된 경우)")
    @ParameterizedTest
    @CsvSource(value = {"6:FIRST", "5:THIRD", "4:FOURTH", "3:FIFTH", "2:MISS", "1:MISS", "0:MISS"}, delimiter = ':')
    void valueOf_getEnum_test(int matchingCount, String expected) {
        assertEquals(Rank.valueOf(matchingCount, false), Rank.valueOf(expected));
    }

    @DisplayName("당첨번호 갯수에 일치하는 타입이 존재하면 해당 등수를 반환한다 (보너스 당첨의 경우)")
    @ParameterizedTest
    @CsvSource(value = {"5:SECOND"}, delimiter = ':')
    void withBonusMatched_valueOf_getEnum_test(int matchingCount, String expected) {
        assertEquals(Rank.valueOf(matchingCount, true), Rank.valueOf(expected));
    }
}
