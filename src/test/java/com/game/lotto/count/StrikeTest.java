package com.game.lotto.count;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrikeTest {

    private final static int STRIKE_COUNT = 3;
    private final static int STRIKE_ADD_COUNT = 4;

    @Test
    void get_count() {
        Strike strike = new Strike(STRIKE_COUNT);
        assertEquals(STRIKE_COUNT, strike.getCount());
    }

    @Test
    void add_count() {
        Strike strike = new Strike(STRIKE_COUNT);
        strike.addCount(STRIKE_ADD_COUNT);
        assertEquals(STRIKE_COUNT + STRIKE_ADD_COUNT, strike.getCount());
    }
}