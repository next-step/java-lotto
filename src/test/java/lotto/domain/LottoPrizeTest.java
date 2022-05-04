package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoPrizeTest {
    @Test
    void fromMatch는_상금_정보를_반환한다() {
        assertAll(
                () -> assertEquals(LottoPrize.FIRST, LottoPrize.fromMatch(new Match(6))),
                () -> assertEquals(LottoPrize.SECOND, LottoPrize.fromMatch(new Match(5))),
                () -> assertEquals(LottoPrize.THIRD, LottoPrize.fromMatch(new Match(4))),
                () -> assertEquals(LottoPrize.FOURTH, LottoPrize.fromMatch(new Match(3))),
                () -> assertEquals(LottoPrize.NONE, LottoPrize.fromMatch(new Match(2))),
                () -> assertEquals(LottoPrize.NONE, LottoPrize.fromMatch(new Match(1))),
                () -> assertEquals(LottoPrize.NONE, LottoPrize.fromMatch(new Match(0)))
        );
    }
}
