package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoPrizeTest {
    @Test
    void fromMatched는_상금_정보를_반환한다() {
        assertAll(
                () -> assertEquals(LottoPrize.FIRST, LottoPrize.fromMatched(6)),
                () -> assertEquals(LottoPrize.SECOND, LottoPrize.fromMatched(5)),
                () -> assertEquals(LottoPrize.THIRD, LottoPrize.fromMatched(4)),
                () -> assertEquals(LottoPrize.FOURTH, LottoPrize.fromMatched(3)),
                () -> assertEquals(LottoPrize.NONE, LottoPrize.fromMatched(2)),
                () -> assertEquals(LottoPrize.NONE, LottoPrize.fromMatched(1)),
                () -> assertEquals(LottoPrize.NONE, LottoPrize.fromMatched(0))
        );
    }
}
