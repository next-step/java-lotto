package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoPrizeTest {
    @Test
    void of는_상금_정보를_반환한다() {
        assertAll(
                () -> assertEquals(LottoPrize.FIRST, LottoPrize.of(new Match(6), false)),
                () -> assertEquals(LottoPrize.SECOND, LottoPrize.of(new Match(5), true)),
                () -> assertEquals(LottoPrize.THIRD, LottoPrize.of(new Match(5), false)),
                () -> assertEquals(LottoPrize.FOURTH, LottoPrize.of(new Match(4), false)),
                () -> assertEquals(LottoPrize.FIFTH, LottoPrize.of(new Match(3), false)),
                () -> assertEquals(LottoPrize.NONE, LottoPrize.of(new Match(1), false)),
                () -> assertEquals(LottoPrize.NONE, LottoPrize.of(new Match(0), false))
        );
    }
}
