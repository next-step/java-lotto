package autoLotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoPrizeTest {

    @ParameterizedTest
    @CsvSource({
            "0, flase, MISS",
            "1, false, MISS",
            "3, false, FIFTH",
            "4, false, FOURTH",
            "5, false, THIRD",
            "5, true, SECOND",
            "6, false, FIRST",
            "7, false, MISS",
    })
    void valueOf(int count, boolean hitBonus, LottoPrize lottPrize) {
        assertEquals(lottPrize, LottoPrize.valueOf(new MatchedLottoCount(count, hitBonus)));
    }
}
