package autoLotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoPrizeTest {

    @ParameterizedTest
    @CsvSource({
            "0,NONE",
            "1,NONE",
            "3,THREE",
            "4,FOUR",
            "5,FIVE",
            "6,SIX",
            "7,NONE",
    })
    void valueOf(int count, LottoPrize lottPrize) {
        assertEquals(lottPrize, LottoPrize.valueOf(count));
    }
}
