import Lotto.constants.LottoPrize;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoPrizeTest {
    @ParameterizedTest
    @CsvSource({
            "3, THREE_MATCH",
            "4, FOUR_MATCH",
            "5, FIVE_MATCH",
            "6, SIX_MATCH"
    })
    void fromMatchCount_ShouldReturnCorrectEnum(int input, LottoPrize expected) {
        assertEquals(expected, LottoPrize.fromMatchCount(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 7, -1})
    void fromMatchCount_ShouldReturnNull_ForInvalidInput(int input) {
        assertNull(LottoPrize.fromMatchCount(input));
    }

    @ParameterizedTest
    @CsvSource({
            "THREE_MATCH, 5000",
            "FOUR_MATCH, 50000",
            "FIVE_MATCH, 1500000",
            "SIX_MATCH, 2000000000"
    })
    void getPrizeMoney_ShouldReturnCorrectValue(LottoPrize prize, int expectedMoney) {
        assertEquals(expectedMoney, prize.getPrizeMoney());
    }
}
