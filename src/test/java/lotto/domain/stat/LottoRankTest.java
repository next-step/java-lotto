package lotto.domain.stat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LottoRankTest {

    @Test
    @DisplayName("of 테스트: numberOfMatched에 맞는 LottoRank 리턴")
    void of() {
        assertEquals(LottoRank.FIRST, LottoRank.of(6));
        assertEquals(LottoRank.SECOND, LottoRank.of(5));
        assertEquals(LottoRank.THIRD, LottoRank.of(4));
        assertEquals(LottoRank.FOURTH, LottoRank.of(3));
        assertEquals(LottoRank.NONE, LottoRank.of(2));
        assertEquals(LottoRank.NONE, LottoRank.of(1));
        assertEquals(LottoRank.NONE, LottoRank.of(0));
    }

    @Test
    @DisplayName("isNotNone 테스트: NONE인 경우 false, 아닌경우 true 리턴")
    void isNotNone() {
        assertTrue(LottoRank.FIRST.isNotNone());
        assertTrue(LottoRank.SECOND.isNotNone());
        assertTrue(LottoRank.THIRD.isNotNone());
        assertTrue(LottoRank.FOURTH.isNotNone());
        assertFalse(LottoRank.NONE.isNotNone());
    }

}
