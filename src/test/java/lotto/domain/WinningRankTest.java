package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("당첨 순위 테스트")
class WinningRankTest {

    @Test
    void valueOf() {
        assertSame(WinningRank.FIRST, WinningRank.valueOf(6));
        assertSame(WinningRank.SECOND, WinningRank.valueOf(5));
        assertSame(WinningRank.THIRD, WinningRank.valueOf(4));
        assertSame(WinningRank.FOURTH, WinningRank.valueOf(3));
        assertSame(WinningRank.NONE, WinningRank.valueOf(2));
        assertSame(WinningRank.NONE, WinningRank.valueOf(1));
        assertSame(WinningRank.NONE, WinningRank.valueOf(0));
    }

    @Test
    void validRanks() {
        List<WinningRank> expected = List.of(
                WinningRank.FOURTH,
                WinningRank.THIRD,
                WinningRank.SECOND,
                WinningRank.FIRST
        );

        List<WinningRank> actual = WinningRank.validRanks();

        assertEquals(expected, actual);
    }
}