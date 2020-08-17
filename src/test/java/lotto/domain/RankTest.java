package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankTest {

    @Test
    public void wrongRange() {
        assertEquals(Rank.of(2, false), Rank.MISS);
        assertEquals(Rank.of(7, false), Rank.MISS);
    }

    @Test
    public void success() {
        assertEquals(Rank.of(0, false), Rank.MISS);
        assertEquals(Rank.of(1, false), Rank.MISS);
        assertEquals(Rank.of(2, false), Rank.MISS);
        assertEquals(Rank.of(3, false), Rank.FIFTH);
        assertEquals(Rank.of(4, false), Rank.FOURTH);
        assertEquals(Rank.of(5, false), Rank.THIRD);
        assertEquals(Rank.of(5, true), Rank.SECOND);
        assertEquals(Rank.of(6, false), Rank.FIRST);
    }
}
