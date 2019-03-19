package lottogame.domain;

import org.junit.Test;

import static lottogame.domain.Rank.*;
import static org.junit.Assert.*;

public class RankTest {

    @Test
    public void valueOf() {
        assertEquals(MISS, Rank.valueOf(-1));
        assertEquals(MISS, Rank.valueOf(0));
        assertEquals(MISS, Rank.valueOf(7));

        assertEquals(FOURTH, Rank.valueOf(3));
        assertEquals(THIRD, Rank.valueOf(4));
        assertEquals(SECOND, Rank.valueOf(5));
        assertEquals(FIRST, Rank.valueOf(6));
    }
}